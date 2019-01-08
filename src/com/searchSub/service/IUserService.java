package com.searchSub.service;

import java.util.ArrayList;
import java.util.Set;

import com.searchSub.po.Customer;
import com.searchSub.po.Question;

public interface IUserService {
	public boolean reg(Customer user);
	public boolean login(Customer user);
	public boolean delete(Customer user);
	public boolean collect(Customer user,Question ques);
	public boolean cancelCollect(Customer user,Question ques);
	public ArrayList myCollect(Customer user);
}
