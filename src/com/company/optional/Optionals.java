package com.company.optional;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(23);
        person.setName("John");
        person.setSurname("Doe");

        System.out.println(person.getAge());
        System.out.println(person.getName());

        person.getSurname();

        String surname = person.getSurname().orElseThrow(RuntimeException::new);

        System.out.println(surname);

        if (person.getSurname().isPresent()) {
            System.out.println(person.getSurname());
        }

        if (person.getSurname().isEmpty()) {
            throw new RuntimeException();
        }

        String surname1 = person.getSurname().get();

        System.out.println(surname1);

        Optional<String> optional = Optional.empty();
        Optional<String> optional1 = Optional.ofNullable(null);
        Optional<String> optional2 = getString();
        optional2.ifPresent(System.out::println);

    }
    static Optional<String> getString() {
        if (false) {
            return Optional.of("Hello");
        }
        return Optional.empty();
    }
}