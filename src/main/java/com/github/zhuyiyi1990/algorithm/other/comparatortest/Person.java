package com.github.zhuyiyi1990.algorithm.other.comparatortest;

public class Person implements Comparable<Person> {

    private int age;

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

}