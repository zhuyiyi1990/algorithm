package com.github.zhuyiyi1990.algorithm.reflect;

public class MyTest {

    public static void main(String[] args) {
        Class<Integer> clazz = int.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());
        Class<Integer> integerClass = Integer.class;
        System.out.println(integerClass.getName());
        System.out.println(integerClass.getCanonicalName());
        Class<Integer> type = Integer.TYPE;
        System.out.println(type.getName());
        System.out.println(type.getCanonicalName());
    }

}
