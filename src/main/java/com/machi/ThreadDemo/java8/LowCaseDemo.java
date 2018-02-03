package com.machi.ThreadDemo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 2018/1/31.
 */
public class LowCaseDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("TaoBao");

        names.add("ZhiFuBao");

        List<String> strings = names.stream().map((String name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());

        for (String s:strings)
            System.out.println(s);
    }

}
