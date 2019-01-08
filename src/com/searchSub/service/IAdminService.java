package com.searchSub.service;

import java.util.List;
import java.util.Map;

import com.searchSub.dao.CustomerDAO;
import com.searchSub.dao.QuestionDAO;
import com.searchSub.po.Administrator;
import com.searchSub.po.Question;



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
	public boolean UpdateFeedback(int id,String answer);
	//用户上传错题
	public boolean UploadFeedback(int id);
	public boolean login(Administrator admin);

}
