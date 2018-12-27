package com.framgia.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import com.framgia.dao.GenericDAO;
import com.framgia.dao.ProductDAO;
import com.framgia.model.Product;

public class ProductDAOImpl extends GenericDAO<Integer, Product> implements ProductDAO {

	public ProductDAOImpl() {
		super(Product.class);
	}
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Product> getProducts() {
		return getSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public List<Product> getProductsByCategoryID(Integer id) {
		List<Product> list = getSession().createQuery("SELECT p FROM Product p "
				+ "INNER JOIN Category c ON p.category.id = c.id "
				+ "where c.id = :id", Product.class).setParameter("id", id).getResultList();
		return list;
	}
	
}
