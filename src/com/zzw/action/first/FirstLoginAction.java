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
		
		if(username.equals("����") && password.equals("123456")) {
			// ��¼����
			ActionContext ac=ActionContext.getContext();
			Integer vc=(Integer) ac.getApplication().get("visitCount");
			if(vc==null)
				vc=new Integer(0);
			vc=vc+1;
			ac.getApplication().put("visitCount", vc);
			// �û���
			ac.getSession().put("username", username);
			// ��ǰʱ��
			ac.put("currentTime", sdf.format(new Date()));
			
			return SUCCESS;
		}
		else
			return ERROR;
	}
}
