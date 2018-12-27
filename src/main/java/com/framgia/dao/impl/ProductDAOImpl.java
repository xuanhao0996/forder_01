package com.framgia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.dao.GenericDAO;
import com.framgia.dao.ProductDAO;
import com.framgia.model.Product;

public class ProductDAOImpl extends GenericDAO<Integer, Product> implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts(int start) {

		// get the current hibernate session

		if (start >= 0) {
			return getSession().createQuery("from Product", Product.class).setFirstResult(start).setMaxResults(4).getResultList();
		} 
			return getSession().createQuery("from Product", Product.class).getResultList();
		
	}

	@Override
	public List<Product> getProductsByCategoryID(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Product> theQuery = getSession().createQuery(
				"select p from Product p inner join Category c " + "on p.category.id = c.id  where " + "c.id = :id",
				Product.class);
		theQuery.setParameter("id", id);

		return theQuery.getResultList();
	}

}
