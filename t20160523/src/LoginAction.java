

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction{
	public LoginAction(){
		System.out.println("LoginAction构造函数");
	}
	private String account;
	public String getAccount() {
		System.out.println("LoginAction getAccount");
		return account;
	}
	public void setAccount(String account) {
		System.out.println("LoginAction setAccount");
		this.account = account;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//使用request
		HttpServletResponse response = ServletActionContext.getResponse();
		//使用response
		ServletContext application = ServletActionContext.getServletContext();
		//使用application
		Map session = ActionContext.getContext().getSession();
		//使用session
				
		session.put("accoun", "111");
		
		System.out.println("LoginAction execute");
		if(account.equals(password)){
			return "success";
		}
		return "fail";
	}
}
