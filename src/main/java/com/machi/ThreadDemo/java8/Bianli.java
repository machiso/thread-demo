package com.machi.ThreadDemo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串去重
 */
public class Bianli {
    public static void main(String[] args) {

        List<String> list = new ArrayList();
        list.add("111");
        list.add("111");
        list.add("111");
        list.add("222");
        list.add("333");


        List<String> strings = list.stream().distinct().collect(Collectors.toList());

//        for (String s : strings)
//            System.out.println(s);

        //java8遍历字符串数组
        strings.forEach(x-> System.out.println(x));


    }
}
