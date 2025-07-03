package com.tw.test;
import static org.junit.jupiter.api.Assertions.*;
import com.tw.dao.CustomerDao;
import com.tw.entity.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestCustomerDao {
    private static CustomerDao dao;

    @BeforeAll
    public static void init(){
        dao = new CustomerDao();
    }

    @Test
    public void testSave() {
        Customer c1 = new Customer(1023,"Jacob","4893493323",5000);
        assertTrue(dao.save(c1));
    }

    @Test
    public void testFindById() {
        Customer c1 = dao.findById(1023);
        assertNotNull(c1);
        System.out.println(c1);
    }
}
