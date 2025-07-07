package com.tw.dao;

import com.tw.entity.Customer;

import javax.persistence.*;
import java.util.List;

public class CustomerDao {
    private EntityManagerFactory emf;

    public CustomerDao() {
        emf = Persistence.createEntityManagerFactory("Vapasi");
    }

    public boolean save(Customer cust) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            em.persist(cust);
            txn.commit();
            return true;
        } catch (Exception e) {
            txn.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public Customer findById(int custId) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Customer.class, custId);
        } finally {
            em.close();
        }
    }

    public List<Customer> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from Customer");
        return query.getResultList();
    }

    public List<Customer> findByCreditRange(double min, double max) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT z FROM Customer z WHERE crLimit BETWEEN :min AND :max");
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

    public List<Customer> findBy5k() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("cust5k");
        query.setParameter("lmt", 5000);
        return query.getResultList();
    }

    public boolean delete(int custId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Customer cust = em.find(Customer.class, custId);
            em.remove(cust);
            txn.commit();
            return true;
        }catch (Exception e) {
            txn.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
