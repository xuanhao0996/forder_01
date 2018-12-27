package com.framgia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.dao.CategoryDAO;
import com.framgia.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategories() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Category> arrCategory = session.createQuery("from Category", Category.class).getResultList();
		tr.commit();
		session.close();
		return arrCategory;
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

}
