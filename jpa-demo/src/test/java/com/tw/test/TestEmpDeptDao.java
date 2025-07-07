package com.tw.test;

import com.tw.dao.EmpDeptDao;
import com.tw.entity.Department;
import com.tw.entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Employee emp = new Employee("Samantha",1950);
        assertTrue(dao.addEmp(emp, 10));
    }

    @Test
    public void testGetDept() {
        Department dept = dao.getDept(10);
        assertNotNull(dept);
        System.out.println(dept);
        List<Employee> emps = dept.getEmps();
        emps.forEach(System.out::println);

    }

    @Test
    public void testGetEmp() {
        Employee emp = dao.getEmp(1);
        assertNotNull(emp);
        System.out.println(emp);
        Department d = emp.getDept();
        System.out.println(d);
    }

    @Test
    public void testDelDept() {
        assertTrue(dao.delDept(10));
    }
}
