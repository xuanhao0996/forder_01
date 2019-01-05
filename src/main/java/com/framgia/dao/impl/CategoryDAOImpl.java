package com.framgia.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.framgia.dao.CategoryDAO;
import com.framgia.dao.GenericDAO;
import com.framgia.model.Category;

public class CategoryDAOImpl extends GenericDAO<Integer, Category> implements CategoryDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class);

	public CategoryDAOImpl() {
		super(Category.class);
	}

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public Category findByName(String categoryName) {
		return (Category) getSession().createQuery("FROM Category WHERE name = ?")
									.setParameter(0, categoryName).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		return getSession().createQuery("FROM Category").getResultList();
	}
	/*
	 * @Override public Category getCategoryByID(Integer id) { Category category =
	 * new Category(); category = (Category) getSession().createQuery("FROM " +
	 * "Category WHERE id = :id").setParameter("id", id).getSingleResult(); return
	 * category; }
	 */

}