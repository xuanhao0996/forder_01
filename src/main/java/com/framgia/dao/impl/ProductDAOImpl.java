package com.framgia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.framgia.dao.ProductDAO;
import com.framgia.model.Product;


public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		Query<Product> theQuery = session.createQuery("from Product", Product.class);

		return  theQuery.getResultList();
	}

	@Override
	public List<Product> getProductsByCategoryID(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Product> theQuery = session.createQuery("select p from Product p inner join Category c "
				+ "on p.category.id = c.id  where "
				+ "c.id = :id", Product.class);
		theQuery.setParameter("id", id);
		
		return theQuery.getResultList();
	}

}
