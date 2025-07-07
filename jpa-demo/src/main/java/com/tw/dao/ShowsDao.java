package com.tw.dao;

import com.tw.entity.Movie;
import com.tw.entity.Multiplex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ShowsDao {
    private EntityManagerFactory emf;

    public ShowsDao() {
        emf = Persistence.createEntityManagerFactory("Vapasi");
    }

    public boolean addMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(movie);
            tx.commit();
            return true;
        }catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    public boolean addMultiplex(Multiplex multiplex) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(multiplex);
            tx.commit();
            return true;
        }catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    public boolean addShow(int movId, int mpexId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            txn.begin();
            Movie movie = em.find(Movie.class, movId);
            Multiplex multiplex = em.find(Multiplex.class, mpexId);
            multiplex.getMovies().add(movie);
            txn.commit();
            return true;
        }catch (Exception e) {
            txn.rollback();
            return false;
        }
    }

    public Movie getMovie(int movId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Movie.class, movId);
    }

    public Multiplex getMultiplex(int mpexId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Multiplex.class, mpexId);
    }

    public boolean delMovie(int movId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Movie movie = em.find(Movie.class, movId);
            em.remove(movie);
            txn.commit();
            return true;
        }catch(Exception e) {
            txn.rollback();
            return false;
        }
    }

    public boolean delMultiplex(int mpexId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Multiplex multiplex = em.find(Multiplex.class, mpexId);
            em.remove(multiplex);
            txn.commit();
            return true;
        }catch (Exception e) {
            txn.rollback();
            return false;
        }
    }
}
