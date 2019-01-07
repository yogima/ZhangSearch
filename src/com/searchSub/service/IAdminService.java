package database.service;

import java.util.List;
import java.util.Map;

import database.dao.CustomerDAO;
import database.dao.QuestionDAO;
import database.pojo.Administrator;
import database.pojo.Question;

public interface IAdminService {
	//各种get/set方法
	public void setCustomerDao(CustomerDAO customerDao);
	public CustomerDAO getCustomerDao();
	public QuestionDAO getQuestionDao();
	public void setQuestionDao(QuestionDAO questionDao);
	public Map getRequest();
	public void setRequest(Map request);
	
	//报错相关操作
	//得到错题
	public List<Question> getErrors();
	//更新错题
	public boolean UpdateFeedback(Question question);
	//用户上传错题
	public boolean UploadFeedback(Question question);
	public boolean login(Administrator admin);
	public boolean reg(Administrator admin);
}
