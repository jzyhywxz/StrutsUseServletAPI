package com.zzw.action.first;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FirstLoginAction extends ActionSupport {
	private String username;
	private String password;
	private static final SimpleDateFormat sdf=
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final long serialVersionUID = 1L;

	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public void setUsername(String u) { username=u; }
	public void setPassword(String p) { password=p; }
	
	@Override
	public String execute() throws Exception {
		super.execute();
		
		if(username.equals("张三") && password.equals("123456")) {
			// 登录次数
			ActionContext ac=ActionContext.getContext();
			Integer vc=(Integer) ac.getApplication().get("visitCount");
			if(vc==null)
				vc=new Integer(0);
			vc=vc+1;
			ac.getApplication().put("visitCount", vc);
			// 用户名
			ac.getSession().put("username", username);
			// 当前时间
			ac.put("currentTime", sdf.format(new Date()));
			
			return SUCCESS;
		}
		else
			return ERROR;
	}
}
