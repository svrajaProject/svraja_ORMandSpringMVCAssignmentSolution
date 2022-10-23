package com.gl.lab5.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.lab5.entity.Customer;
import com.gl.lab5.service.CustomerService;

/**
 * @author svraja
 *
 */
@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();

		}
	}

	@Override
	@Transactional
	public List<Customer> fetchAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();
		return customers;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
	}

	@Override
	public Customer findById(int id) {
		Transaction tx = session.beginTransaction();
		Customer cs = session.get(Customer.class, id);
		tx.commit();
		return cs;
	}

	@Override
	public Customer DeleteById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
		return customer;
	}

}
