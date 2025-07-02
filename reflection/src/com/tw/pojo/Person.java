package com.tw.pojo;

import java.security.BasicPermission;

public class Person {
    private String name;
    private int age;

    static {
        System.out.println("Person class loaded");
    }

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    private void print() {
        SecurityManager mgr = new SecurityManager();
        mgr.checkPermission(new BasicPermission("Private area") {});
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
