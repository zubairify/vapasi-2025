package com.tw.reflect;

import com.tw.pojo.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonReflection {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Polo", 21);
        System.out.println(p1);

//        Class c1 = p1.getClass();
        Class c1 = Class.forName("com.tw.pojo.Person");
        System.out.println(c1);

        System.out.println("-- List of constructors --");
        Constructor[] cons = c1.getDeclaredConstructors();
        for (Constructor c : cons) {
            System.out.println(c);
        }

        System.out.println("-- List of methods --");
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("-- List of fields --");
        Field[] fields = c1.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }
}
