package com.framgia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;
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
	public Product findByName(String productName) {
		return (Product) getSession().createQuery("FROM Product WHERE name = ?")
									.setParameter(0, productName).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll() {
		return getSession().createQuery("FROM Product").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByCategoryId(Integer id) {
		return getSession().createQuery("SELECT p FROM Product p "
										+ "WHERE p.category.id = :id")
										.setParameter("id", id)
										.getResultList();
	}

	@Override
	public Product findByIdUsingLock(Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*

	@Override
	public Product getProductsById(Integer id) {
		return (Product) getSession().createQuery("FROM Product WHERE id = :id").setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts(int start) {
		if(start<0) {
			return getSession().createQuery("FROM Product", Product.class).getResultList();
				}
			return getSession().createQuery("FROM Product", Product.class).setFirstResult(start).setMaxResults(4).getResultList();
	}*/
		
}