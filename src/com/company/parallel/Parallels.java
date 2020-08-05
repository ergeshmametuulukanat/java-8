package com.company.parallel;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Parallels {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
            list.add(10_000_000 - 1);
        }
        System.out.println(new Date());
        list.parallelStream().sorted().filter(x -> x % 2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
        list.stream().filter(x -> x % 2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
        list.parallelStream().sorted().count();
        System.out.println(new Date());


        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
        System.out.println(new Date().getTime());
        list.stream().sorted().count();
        list.parallelStream().sorted().count();
        System.out.println(new Date().getTime());

        List<Integer> list3 = new LinkedList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list3.add(i);
            list3.add(10_000_000 - 1);
        }
        System.out.println(new Date());
        list3.parallelStream().sorted().count();
        System.out.println(new Date());


        List<Integer> list4 = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            list4.add(i);
        }
        list4.stream().forEach(System.out::println);
        list4.parallelStream().forEach(System.out::println);
    }
}
