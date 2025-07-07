package com.tw.test;

import com.tw.dao.EmpDeptDao;
import com.tw.entity.Department;
import com.tw.entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEmpDeptDao {
    private static EmpDeptDao dao;

    @BeforeAll
    public static void init() {
        dao = new EmpDeptDao();
    }

    @Test
    public void testAddDept() {
        Department dept = new Department(10, "Sales", "Chennai");
        assertTrue(dao.addDept(dept));
    }

    @Test
    public void testAddEmp() {
        Employee emp = new Employee("Frudo",1850);
        assertTrue(dao.addEmp(emp, 10));
    }

    @Test
    public void testGetDept() {
        Department dept = dao.getDept(10);
        assertNotNull(dept);
        System.out.println(dept);
    }

    @Test
    public void testGetEmp() {
        Employee emp = dao.getEmp(10);
        assertNotNull(emp);
        System.out.println(emp);
    }
}
