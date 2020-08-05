package com.company.lyambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lyambda {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        };

        Runnable runnable1 = () -> System.out.println("Hello");

        ActionListener actionListener1 = (event) -> System.out.println("Hello");

        Stream<String> stream = Stream.of("a", "b", "c");
        stream.map(s -> {
            System.out.println("map:" + s);
            return s;
        }).filter(s -> {
            System.out.println("filter:" + s);
            return s.equals("c");
        }).forEach(System.out::println);

//        Stream<String> stream1 = Stream.of("a", "b", "c");
        Supplier<Stream<String>> supplier =() -> Stream.of("a", "b", "c");
        supplier.get().forEach(System.out::println);
        supplier.get().forEach(System.out::println);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.getParallelism());

        Stream<String> stream2 = Stream.of("a", "b", "c");
        stream2.parallel().sorted((s1, s2) -> {
            System.out.println("sort: " + s1 + " " + s2);
            return s1.compareTo(s2);
        }).map(x -> {
            System.out.println("map: " + x + " " + Thread.currentThread().getName());
            return x;
        }).map(x -> {
            System.out.println("map: " + x + " " + Thread.currentThread().getName());
            return x;
        }).forEach(System.out::println);

        Function<Integer, String> function = x -> x.toString();
        Function<Integer, Integer> increment = number -> number + 1;

        Integer incrementedNumber = increment.apply(12);

        System.out.println("incrementedNumber number is " + incrementedNumber);

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("sum is " + sum.apply( 1, 5));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 8);


        Predicate<Integer> predicate = x -> x > 5;
//        System.out.println(predicate.test(3));
//        System.out.println(predicate.test(10));
        Predicate<Integer> isEven = number -> number % 2 == 0;

        Integer firstEvenNumber = numbers.stream()
                .filter(isEven.and(number -> number > 2))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Even number not found"));

        System.out.println("firstEvenNumber is " + firstEvenNumber);


        List<Integer> filteredNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());

        System.out.println("filteredNumbers numbers are ");
        filteredNumbers.forEach(x -> System.out.print(x + " "));
        System.out.println();

        Consumer<Integer> consumer = x1 -> System.out.println(x1);
//        consumer.accept(10);

        Consumer<Integer> printer = System.out::println;

        numbers.forEach(printer);

        Supplier<Integer> supplier1 = () -> 5;
        Supplier<Integer> randomNumber = () -> new Random().nextInt();

        Integer integer = randomNumber.get();

        System.out.println(integer);


        UnaryOperator<Integer> unaryOperator = x -> x * x;

        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;

    }
}
