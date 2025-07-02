package com.tw.reflect;

import com.tw.pojo.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DynamicReflection {
    public static void main(String[] args) throws Exception {

        Class c1 = Class.forName("com.tw.pojo.Person");

        Constructor<Person> constructor = c1.getConstructor(String.class, int.class);
        Person p1 = constructor.newInstance("Polo", 21);

        Method m1 = c1.getDeclaredMethod("print", null);
        m1.setAccessible(true);
        m1.invoke(p1);
    }
}
