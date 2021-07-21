package com.travel.jdk8.stream;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.Comparator;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
import java.util.GregorianCalendar;
import java.util.Collection;
import java.util.Collections;
import java.lang.Iterable;
import java.util.function.Supplier;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.chrono.IsoChronology;
import java.lang.Number;
import java.util.stream.*;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ConcurrentMap;

public class ParallelismExamples {

    public static void main(String... args) {

        // Create sample data

        List<Person> roster = Person.createRoster();

        System.out.println("Contents of roster:");
        roster
            .stream()
            .forEach(p -> p.printPerson());
        System.out.println();

        // 1. Average age of male members in parallel

        double average = roster
            .parallelStream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();

        System.out.println("Average age of male members in parallel: " +
            average);

        // 2. Concurrent reduction example

        ConcurrentMap<Person.Sex, List<Person>>
            byGenderParallel =
            roster
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(Person::getGender));

        List<Map.Entry<Person.Sex, List<Person>>>
            byGenderList =
            new ArrayList<>(byGenderParallel.entrySet());

        System.out.println("Group members by gender:");
        byGenderList
            .stream()
            .forEach(e -> {
                System.out.println("Gender: " + e.getKey());
                e.getValue()
                    .stream()
                    .map(Person::getName)
                    .forEach(f -> System.out.println(f)); });

        // 3. Examples of ordering and parallelism

        System.out.println("Examples of ordering and parallelism:");
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers =
            new ArrayList<>(Arrays.asList(intArray));

        System.out.println("listOfIntegers:");
        listOfIntegers
            .stream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("listOfIntegers sorted in reverse order:");
        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers, reversed);
        listOfIntegers
            .stream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Parallel stream");
        listOfIntegers
            .parallelStream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Another parallel stream:");
        listOfIntegers
            .parallelStream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("With forEachOrdered:");
        listOfIntegers
            .parallelStream()
            .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");

        // 4. Example of interference

        try {
            List<String> listOfStrings =
                new ArrayList<>(Arrays.asList("one", "two"));

            // This will fail as the peek operation will attempt to add the
            // string "three" to the source after the terminal operation has
            // commenced.

            String concatenatedString = listOfStrings
                .stream()

                // Don't do this! Interference occurs here.
                .peek(s -> listOfStrings.add("three"))

                .reduce((a, b) -> a + " " + b)
                .get();

            System.out.println("Concatenated string: " + concatenatedString);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }

        // 5. Stateful lambda expressions examples

        List<Integer> serialStorage = new ArrayList<>();

        System.out.println("Serial stream:");
        listOfIntegers
            .stream()

            // Don't do this! It uses a stateful lambda expression.
            .map(e -> { serialStorage.add(e); return e; })

            .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");

        serialStorage
            .stream()
            .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Parallel stream:");
        List<Integer> parallelStorage = Collections.synchronizedList(
            new ArrayList<>());
        listOfIntegers
            .parallelStream()

            // Don't do this! It uses a stateful lambda expression.
            .map(e -> { parallelStorage.add(e); return e; })

            .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");

        parallelStorage
            .stream()
            .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
    }
}
