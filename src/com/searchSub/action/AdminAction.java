package database.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import database.pojo.Administrator;
import database.pojo.Customer;
import database.pojo.Question;
import database.service.AdminService;
import database.service.CustomerService;

public class AdminAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map session;
	private Administrator admin;
	private Customer loginUser;
	private Question question;
	private CustomerService customerService;
	private AdminService adminService;
	private List<Question> errors;
	public AdminAction() {}
	public Map getSession() 
	{
		return this.session;
	}
	public void setSession(Map session) 
	{
		this.session=session;
	}
	public Administrator getAdmin() 
	{
		return this.admin;
	}
	public void setAdmin(Administrator admin) 
	{
		this.admin=admin;
	}
	public Customer getLoginUser() 
	{
		return this.loginUser;
	}
	public void setLoginUser(Customer loginUser) 
	{
		this.loginUser=loginUser;
	}
	public Question getQuestion() 
	{
		return this.question;
	}
	public void setQuestion(Question question) 
	{
		this.question=question;
	}
	public CustomerService getCustomerService() 
	{
		return this.customerService;
	}
	public void setCustomerService(CustomerService customerService) 
	{
		this.customerService=customerService;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public List<Question> getErrors() {
		return errors;
	}
	public void setErrors(List<Question> errors) {
		this.errors = errors;
	}



	public String getFeedback() 
	{
		AdminService AdminServ = this.adminService;
		if (AdminServ.getErrors()!=null)
		{
			this.errors=AdminServ.getErrors();
			return "success";
		}
		else
		return "fail";
	}
	
	public String UploadFeedback() 
	{
		AdminService AdminServ = this.adminService;
		if (AdminServ.UploadFeedback(question))
		{
			this.errors=AdminServ.getErrors();
			return "success";
		}
		else
		return "fail";
	}
	
	public String UpdateFeedback() 
	{
		AdminService AdminServ = this.adminService;
		if (AdminServ.UpdateFeedback(question))
		{
			this.errors=AdminServ.getErrors();
			return "success";
		}
		else
		return "fail";
	}

	public String register() {
		adminService.reg(admin);
		return "AdminregisterSuccess";
	}
	
	public String login() {
		if(adminService.login(admin)) {
			session.put("loginAdmin", admin);
			return "AdminloginSuccess";
		}
		else
			return "AdminloginFail";
	}
	
	
}