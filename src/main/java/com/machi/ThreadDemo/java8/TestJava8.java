package com.machi.ThreadDemo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dell on 2018/2/1.
 */
public class TestJava8 {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person(1,"aaa","0001"));
        persons.add(new Person(4,"ccc","0004"));
        persons.add(new Person(3,"ccc","0003"));
        persons.add(new Person(2,"bbb","0002"));
        persons.add(new Person(5,"bbb","0002"));
        persons.add(new Person(6,"bbb","0002"));

        //按照某个字段排序
        List<Person> personList = persons.stream().sorted(Comparator.comparing(Person::getCode)).collect(Collectors.toList());

        //对code去重
        List<String> collect = personList.stream().map(Person::getCode).distinct().collect(Collectors.toList());

        collect.forEach(x->{
            System.out.println(x);
        });

    }

}
