package com.framgia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.dao.CategoryDAO;
import com.framgia.model.Category;


public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean create(Category object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category object) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Category findById(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Category> query = session.createQuery("FROM Category WHERE id = :id");
		return query.setParameter("id", categoryId).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Category> query = session.createQuery("FROM Category");
		return query.getResultList();
	}
		
}
