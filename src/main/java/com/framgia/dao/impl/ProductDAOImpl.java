package com.framgia.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.framgia.dao.ProductDAO;
import com.framgia.model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts(int start) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Product> arrProducts = null;
		if (start >= 0) {
			arrProducts = session.createQuery("from Product", Product.class).setFirstResult(start).setMaxResults(4).getResultList();
		} else {
			arrProducts = session.createQuery("from Product", Product.class).getResultList();
		}
		tr.commit();
		session.close();
		return arrProducts;
	}

	@Override
	public List<Product> getProductsByCategoryID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// create a query
		Query<Product> theQuery = session.createQuery(
				"select p from Product p inner join Category c " + "on p.category.id = c.id  where " + "c.id = :id",
				Product.class);
		theQuery.setParameter("id", id);

		return theQuery.getResultList();
	}

}
