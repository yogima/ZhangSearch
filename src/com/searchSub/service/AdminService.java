package database.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;


import com.opensymphony.xwork2.ActionContext;
import database.pojo.Administrator;
import database.dao.AdminDAO;
import database.dao.CustomerDAO;
import database.dao.ICustomerDAO;
import database.dao.IQuestionDAO;
import database.dao.QuestionDAO;
import database.pojo.Customer;
import database.pojo.Question;


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
	public boolean UpdateFeedback(Question question) {
		// TODO Auto-generated method stub
		question.setError(0);
		questionDao.save(question);
		return false;
	}
	//上传错题
	public boolean UploadFeedback(Question question) {
		// TODO Auto-generated method stub
		question.setError(1);
		questionDao.save(question);
		return false;
	}

	public boolean reg(Administrator admin) {
		// TODO Auto-generated method stub
		adminDao.save(admin);
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

	

}
