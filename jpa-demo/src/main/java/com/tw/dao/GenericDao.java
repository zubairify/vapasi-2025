package com.tw.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao<Z> {
    private EntityManagerFactory emf;
    private Class<Z> entityClass;

    public GenericDao(Class<Z> entityClass) {
        emf = Persistence.createEntityManagerFactory("Vapasi");
        this.entityClass = entityClass;
    }

    public boolean save(Z entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        txn.begin();
        em.persist(entity);
        txn.commit();
        return true;
    }

    public Z findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(entityClass, id);
    }

}

