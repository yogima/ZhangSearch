package com.searchSub.action;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.searchSub.po.Customer;
import com.searchSub.po.Question;
import com.searchSub.service.IUserService;

public class UserAction implements SessionAware,RequestAware{
	
	private Map session,request;

	public UserAction() {
		// TODO Auto-generated constructor stub
	}

	private Customer user;
	private Question ques;//取消收藏时用,不要忘记get和set方法
	private IUserService userService = null;
	
	public void setUser(Customer user) {
		this.user = user;
	}
	
	public Customer getUser() {
		return user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String register() {
		userService.reg(user);
		return "registerSuccess";
	}
	
	public String login() {
		if(userService.login(user)) {
			session.put("loginUser", user);
			return "loginSuccess";
		}
		else
			return "loginFail";
	}
	
	public String collect() {
		if(userService.collect((Customer) session.get("loginUser"), (Question)session.get("ques"))) {
			request.put("isCollectionSuccess", "收藏成功");
			return "collectSuccess";
		}
		else {
			request.put("isCollectionSuccess", "收藏失败");
			return "collectFail";
		}
			
	}
	
	public String cancelCollect() {
		if(userService.cancelCollect((Customer) session.get("loginUser"),ques)) {
			request.put("isCollectionSuccess", "取消收藏成功");
			return "cancelCollectSuccess";
		}	
		else {
			request.put("isCollectionSuccess", "取消收藏失败");
			return "cancelCollectFail";
		}
	}
	
	public String myCollect() {
		ArrayList collectSet = userService.myCollect((Customer) session.get("loginUser"));
		request.put("collectSet", collectSet);
		return "myCollectSuccess";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public Question getQues() {
		return ques;
	}

	public void setQues(Question ques) {
		this.ques = ques;
	}

	
}
