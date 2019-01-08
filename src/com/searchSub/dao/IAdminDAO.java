package com.searchSub.dao;

import java.util.List;

import com.searchSub.po.Administrator;



public interface IAdminDAO {
	public void save(Administrator transientInstance);
	public void delete(Administrator  transientInstance);
	public void update(Administrator  transientInstance);
	public List findByHQL(String hql);
	
}
