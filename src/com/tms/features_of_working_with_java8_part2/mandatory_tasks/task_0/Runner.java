package com.tms.features_of_working_with_java8_part2.mandatory_tasks.task_0;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Create a collection of the ArrayList class and fill it with random elements of type Integer.
 * Using Streams:
 *   -Remove duplicates
 *   -Print all even elements in the range from 7 to 17 (inclusive)
 *   -Each element multiplied by 2
 *   -Sort and display the first 4 elements\
 *   -Display the number of elements in the stream
 *   -Display the arithmetic mean of all numbers in the stream
 */

public class Runner {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list =
                random.ints(20, -50, 51)
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println("Original list: ");
        list.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Remove duplicates
        System.out.println("Duplicates removed: ");
        list.stream()
                .distinct()
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Print all even elements in the range from 7 to 17 (inclusive)
        System.out.println("Even elements from 7 to 17: ");
        list.stream()
                .filter(i -> i > 7 && i <= 17)
                .filter(i -> (i ^ 1) != 0)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Each element multiplied by 2
        System.out.println("Each element is multiplied by 2: ");
        list.stream()
                .map(i -> i * 2)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Sort and display the first 4 elements
        System.out.println("Sort and display the first 4 elements: ");
        list.stream()
                .sorted()
                .limit(4)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Display the number of elements in the stream
        System.out.println("Number of elements in stream: ");
        long count  = list.stream().count();
        System.out.println(count);

        //Display the number of elements in the stream
        System.out.println("Display the arithmetic mean of all numbers in the stream: ");
        double average  = list.stream().mapToInt(i -> i).average().getAsDouble();
        System.out.println(average);
    }

}
