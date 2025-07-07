package com.tw.test;

import com.tw.dao.ShowsDao;
import com.tw.entity.Movie;
import com.tw.entity.Multiplex;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShowDao {
    private static ShowsDao dao;

    @BeforeAll
    public static void init() {
        dao = new ShowsDao();
    }

    @Test
    public void testAddMovie() {
        Movie movie = new Movie();
        movie.setMovId(123);
        movie.setTitle("F1");
        assertTrue(dao.addMovie(movie));
    }

    @Test
    public void testAddMultiplex() {
        Multiplex multiplex = new Multiplex();
        multiplex.setMpexId(10);
        multiplex.setName("PVR");
        assertTrue(dao.addMultiplex(multiplex));
    }

    @Test
    public void testAddShow() {
        assertTrue(dao.addShow(123, 10));
    }

    @Test
    public void testGetMovie() {
        Movie movie = dao.getMovie(123);
        assertNotNull(movie);
        System.out.println(movie.getTitle());
    }

    @Test
    public void testGetMultiplex() {
        Multiplex multiplex = dao.getMultiplex(123);
        assertNotNull(multiplex);
        System.out.println(multiplex.getName());
    }

    @Test
    public void testDelMovie() {
        assertTrue(dao.delMovie(123));
    }

    @Test
    public void testDelMultiplex() {
        assertTrue(dao.delMultiplex(123));
    }
}
