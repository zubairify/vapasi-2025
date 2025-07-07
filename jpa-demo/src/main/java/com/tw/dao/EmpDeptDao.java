package com.tw.dao;

import com.tw.entity.Department;
import com.tw.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmpDeptDao {
    private EntityManagerFactory emf;

    public EmpDeptDao() {
        emf = Persistence.createEntityManagerFactory("Vapasi");
    }

    public boolean addDept(Department dept) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn =  em.getTransaction();
        try {
            txn.begin();
            em.persist(dept);
            txn.commit();
            return true;
        } catch (Exception e) {
            txn.rollback();
            return false;
        }
    }

    public boolean addEmp(Employee emp, int deptNo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn =  em.getTransaction();
        try {
            txn.begin();
            Department dept = em.find(Department.class, deptNo);
            emp.setDept(dept);
            em.persist(emp);
            txn.commit();
            return true;
        } catch (Exception e) {
            txn.rollback();
            return false;
        }
    }

    public Department getDept(int deptNo) {
        EntityManager em = emf.createEntityManager();
        return em.find(Department.class, deptNo);
    }

    public Employee getEmp(int empNo) {
        EntityManager em = emf.createEntityManager();
        return em.find(Employee.class, empNo);
    }
}
