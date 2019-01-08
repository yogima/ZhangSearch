package com.searchSub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.searchSub.po.Administrator;



public class AdminDAO extends BaseHibernateDao implements IAdminDAO{

	public void save(Administrator transientInstance) {
		System.out.println("execute --save()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.save(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}

	

	public void delete(Administrator transientInstance) {
		System.out.println("execute --delete()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.delete(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}

	public void update(Administrator transientInstance) {
		System.out.println("execute --update()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.update(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}

	public List findByHQL(String hql) {
		System.out.println("execute --findByHQL()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			tran.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
}
