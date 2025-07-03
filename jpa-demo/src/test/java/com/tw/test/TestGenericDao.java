package com.tw.test;
import static org.junit.jupiter.api.Assertions.*;
import com.tw.dao.GenericDao;
import com.tw.entity.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestGenericDao {

    private static GenericDao<Customer, Integer> dao;

    @BeforeAll
    public static void init() {
        dao = new GenericDao<Customer, Integer>(Customer.class);
    }

    @Test
    public void testSave() {
        Customer cust = new Customer(153,"Frank","438393924",3500);
        assertTrue(dao.save(cust));
    }

    @Test
    public void testFind() {
        Customer cust = dao.findById(153);
        assertNotNull(cust);
        System.out.println(cust);
    }
}
