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
	public List<Category> getCategories() {
		
		return getSession().createQuery("from Category", Category.class).getResultList();
	}

	@Override
	public boolean create(Category object) {
		return false;
	}

	@Override
	public boolean update(Category object) {
		return false;
	}

	@Override
	public boolean delete(Category object) {
		return false;
	}

	@Override
	public Category findById(int categoryId) {
		return null;
	}

	@Override
	public Category getCategoryByID(Integer id) {
		Category category = new Category();
		category = (Category) getSession().createQuery("FROM "
				+ "Category WHERE id = :id").setParameter("id", id).getSingleResult();
		return category;
	}

	
}
