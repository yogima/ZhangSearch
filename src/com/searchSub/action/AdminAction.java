package com.searchSub.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.searchSub.po.Administrator;
import com.searchSub.po.Customer;
import com.searchSub.po.Question;
import com.searchSub.service.AdminService;
import com.searchSub.service.UserService;



public class AdminAction extends ActionSupport{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;	
	private Map session;
	private Administrator admin;
	private Customer loginUser;
	private Question question;
	private UserService customerService;
	private AdminService adminService;
	private List<Question> feedList;
	private int question_id;
	private String newAnswer;
	public AdminAction() {}

	
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
	public UserService getCustomerService() 
	{
		return this.customerService;
	}
	public void setCustomerService(UserService customerService) 
	{
		this.customerService=customerService;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	
	
	public String getNewAnswer() {
		return newAnswer;
	}
	public void setNewAnswer(String newAnswer) {
		this.newAnswer = newAnswer;
	}
	public List<Question> getFeedList() {
		return feedList;
	}


	public void setFeedList(List<Question> feedList) {
		this.feedList = feedList;
	}


	public String getFeedback() 
	{
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		Map session=(Map) ctx.getSession();

		AdminService AdminServ = this.adminService;
		if (AdminServ.getErrors()!=null)
		{
			this.feedList=AdminServ.getErrors();
			Question ques=feedList.get(0);
			session.put("ques", ques);
			return "success";
		}
		else
		return "fail";
	}
	
	public String UploadFeedback() 
	{
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		Map session=(Map) ctx.getSession();
		Question ques=(Question) session.get("ques");
		AdminService AdminServ = this.adminService;
		if (AdminServ.UploadFeedback(ques.getQuestionId()))
		{
			return "success";
		}
		else
		return "fail";
	}
	
	public String UpdateFeedback() 
	{
		AdminService AdminServ = this.adminService;
		if (AdminServ.UpdateFeedback(question.getQuestionId(),question.getAnswer()))
		{
			return "success";
		}
		else
		return "fail";
	}

	
	public String login() {
		if(adminService.login(admin)) {
			return "success";
		}
		else
			return "fail";
	}
	
	
	
}