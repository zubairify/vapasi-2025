package com.tw.dao;

import javax.persistence.*;
import java.util.List;

public class GenericDao<Z,P> {
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

    public Z findById(P id) {
        EntityManager em = emf.createEntityManager();
        return em.find(entityClass, id);
    }

    public List<Z> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from "+entityClass.getName());
        return query.getResultList();
    }
}

