package com.zzw.action.second;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SecondLoginAction extends ActionSupport implements ServletContextAware, ServletRequestAware {
	private String username;
	private String password;
	private static final SimpleDateFormat sdf=
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final long serialVersionUID = 1L;

	ServletContext application;
	HttpServletRequest request;
	
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public void setUsername(String u) { username=u; }
	public void setPassword(String p) { password=p; }
	
	@Override
	public void setServletRequest(HttpServletRequest r) {
		request=r;
	}

	@Override
	public void setServletContext(ServletContext a) {
		application=a;
	}

	@Override
	public String execute() throws Exception {
		super.execute();
		
		if(username.equals("张三")&&password.equals("123456")) {
			// 登录次数
			Integer vc=(Integer) application.getAttribute("visitCount");
			if(vc==null)
				vc=new Integer(0);
			vc=vc+1;
			application.setAttribute("visitCount", vc);
			// 用户名
			ActionContext.getContext().getSession().put("username", username);
			// 当前时间
			request.setAttribute("currentTime", sdf.format(new Date()));
			return SUCCESS;
		}
		else
			return ERROR;
	}
}
