package com.tw.lambda;

@FunctionalInterface
interface Greeting {
    String sayHello();
}

interface Maths {
    int add(int a, int b);
}

public class HelloDemo {
    public static void main(String[] args) {
        Greeting g1 = () -> "Happy Holidays";
        System.out.println(g1.sayHello());

        Greeting g2 = () -> {
            String msg = "Welcome back";
            return msg;
        };
        System.out.println(g2.sayHello());
        Maths m1 = (x, y) -> x + y;
        System.out.println(m1.add(10, 20));
        Maths m2 = Integer::sum;
        System.out.println(m2.add(10, 20));
        Maths m3 = HelloDemo::sum;
        System.out.println(m3.add(100, 200));
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
