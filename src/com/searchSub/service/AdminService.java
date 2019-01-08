package com.searchSub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;


import com.opensymphony.xwork2.ActionContext;
import com.searchSub.dao.AdminDAO;
import com.searchSub.dao.CustomerDAO;
import com.searchSub.dao.QuestionDAO;
import com.searchSub.po.Administrator;
import com.searchSub.po.Question;



public class AdminService implements IAdminService{
	private CustomerDAO customerDao = null;
	private QuestionDAO questionDao=null;
	private AdminDAO adminDao=null;
	private Map request;
	public void setCustomerDao(CustomerDAO customerDao) {
		System.out.println("注入customerDao");
		this.customerDao = customerDao;
	}
	public CustomerDAO getCustomerDao() {
		System.out.println("得到customerDao");
		return  this.customerDao;

	}
	public QuestionDAO getQuestionDao() {
		return this.questionDao;
	}
	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}	
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	public Map getRequest() {
		return request;
	}
	public void setRequest(Map request) {
		this.request = request;
	}
	public AdminDAO getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}
	
	//得到错题
	public List<Question> getErrors() 
	{
		QuestionDAO q_dao=this.questionDao;
		List<Question> Errors=q_dao.getErrors();
		
		return 	Errors;
	}
	//修改错题
	public boolean UpdateFeedback(int id,String answer) {
		// TODO Auto-generated method stub
		Question question=questionDao.findById(id);
		question.setAnswer(answer);
		question.setError(0);
		questionDao.update(question);
		return true;
	}
	//上传错题
	public boolean UploadFeedback(int id) {
		// TODO Auto-generated method stub
		Question question=questionDao.findById(id);
		question.setError(1);
		questionDao.update(question);
		return true;
	}
	public boolean login(Administrator admin) {
		// TODO Auto-generated method stub
		String account = admin.getAccount();
		String passwd = admin.getPassword();
		String hql = "from Administrator as adm where adm.account='" + account + "' and adm.password='" + passwd + "'";
		
		List u = adminDao.findByHQL(hql);
		if(u != null)
			return true;
		else
			return false;
	}
	
	
	//得到题目
	public Question getQuestionById(int question_id) {
		Question q;
		if(questionDao.findById(question_id)!=null)
		{
			q=questionDao.findById(question_id);
			return q;
		}
		else 
			return null;
	}


}
