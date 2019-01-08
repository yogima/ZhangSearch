package com.searchSub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;

import com.searchSub.dao.ICustomerDAO;
import com.searchSub.dao.IQuestionDAO;
import com.searchSub.po.Customer;
import com.searchSub.po.Question;

public class UserService implements IUserService {
	private ICustomerDAO userDao = null;
	private IQuestionDAO quesDao = null;

	public void setUserDao(ICustomerDAO userDao) {
		this.userDao = userDao;
	}

	public void setQuesDao(IQuestionDAO quesDao) {
		this.quesDao = quesDao;
	}

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean reg(Customer user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		return true;
	}

	@Override
	public boolean login(Customer user) {
		// TODO Auto-generated method stub
		String account = user.getAccount();
		String passwd = user.getPassword();
		String hql = "from Customer as cus where cus.account='" + account + "' and cus.password='" + passwd + "'";
		
		List u = userDao.findByHQL(hql);
		if(u != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Customer user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
		return true;
	}

	@Override
	public boolean collect(Customer user, Question ques) {
		// TODO Auto-generated method stub
		String userhql = "From Customer where account='"+user.getAccount()+"'";
		
		Transaction tran = null; 
		try {
			ArrayList u = (ArrayList) userDao.findByHQL(userhql);
			user = (Customer) u.get(0);
			
			user.getWrongQues().add(ques);
			tran = userDao.getSession().beginTransaction();
			userDao.update(user);
			tran.commit();
			return true;
		}catch (Exception e) { 
			e.printStackTrace();
			if(tran != null) 
				tran.rollback();
			return false; 
		} finally { 
			userDao.getSession().close();
		}

	}

	@Override
	public boolean cancelCollect(Customer user, Question ques) {
		// TODO Auto-generated method stub
		String quesHql = "From Question where answer='"+ques.getAnswer()+"'";
		ques = (Question) quesDao.findByHQL(quesHql).get(0);
		System.out.println(ques.getQuestion());
		user.getWrongQues().remove(ques);
		userDao.update(user);
		return true;
	}

	@Override
	public ArrayList myCollect(Customer user) {
		// TODO Auto-generated method stub
		String hql = "From Customer where account='"+user.getAccount()+"'";
		user = (Customer) userDao.findByHQL(hql).get(0);
		
		ArrayList quesList = new ArrayList();
		
		Set set = user.getWrongQues();
		Iterator it = set.iterator();  
		while (it.hasNext()) {  
		    quesList.add(it.next()); 
		}  
	
		return quesList;
	}
	
}
