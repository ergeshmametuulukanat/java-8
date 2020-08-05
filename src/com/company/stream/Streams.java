package com.company.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Stream<String> stream = list.stream();
        stream.forEach(x -> System.out.println());

        list.stream().forEach(x -> System.out.println(x));

        Set<String> strings = list.stream().filter(x -> x.equals("one")).collect(Collectors.toSet());


        list.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));

        int min = Stream.of(1, 2).min(Comparator.comparing(x -> x)).get();
        int max = Stream.of(1, 2).max(Comparator.comparing(x -> x)).get();
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println(count);

        Stream.of("one", "two").sorted().collect(Collectors.toList());
        Stream.of("one", "two").limit(1).collect(Collectors.toList());
        Stream.of("one", "two").distinct().collect(Collectors.toList());
        Stream.of("one", "two").skip(1).collect(Collectors.toList());
        String string = Stream.of("one", "two").filter(x -> x.equals("one")).findAny().get();
        boolean isPresent = Stream.of("one", "two").filter(x -> x.equals("one")).findAny().isPresent();
        int integer = Stream.of(1, 2).mapToInt(x -> x).sum();
        long longNumber = Stream.of(1, 2).count();
        String str = Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get();

        IntStream intStream = Stream.of(1, 2).mapToInt(x -> x);
        intStream.summaryStatistics().getAverage();

        Stream.of("one", "two").collect(Collectors.toCollection(ArrayList::new));
        Stream.of("one", "two").collect(Collectors.toCollection(TreeSet::new));

    }
}
