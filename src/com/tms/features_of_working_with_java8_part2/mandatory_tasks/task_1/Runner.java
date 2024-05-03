package com.tms.features_of_working_with_java8_part2.mandatory_tasks.task_1;

import java.io.*;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Create a collection of the ArrayList class with the values of the names of all students in the group
 * Using Streams:
 *   -Return the number of people with your name (regardless of upper/lower case letters)
 *   -Select all names starting with "a" (regardless of upper/lower case letters)
 *   -Sort and return the first element of the collection or "Empty" if the collection is empty
 */

public class Runner {

    private static final String PATH_TO_FILE = "src/com/tms/features_of_working_with_java8_part2/mandatory_tasks/task_1/student_names.txt";
    private static List<String> names = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File(PATH_TO_FILE);
        names = getStudentNames(file);

        //Return the number of people with your name (regardless of upper/lower case letters)
        String myName = "ALEKSANDR";
        System.out.print("Number of students in my name: " + numberOfStudentsInMyName(myName) + "\n\n");

        //Select all names starting with "a" (regardless of upper/lower case letters)
        String prefix = "a";
        System.out.print("Names starting with \"a\": " + namesStartingWith(prefix).toString() + "\n\n");

        //Sort and return the first element of the collection or "Empty" if the collection is empty
        System.out.println("First element of the sorted collection: " + sortAndGetFirst());

    }

    private static List<String> getStudentNames(File file) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            reader.lines()
                    .forEach(names::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
    }

    private static long numberOfStudentsInMyName(String name) {
        return names.stream()
                .filter(name::equalsIgnoreCase)
                .count();
    }

    private static List<String> namesStartingWith(String prefix) {
        return names.stream()
                .distinct()
                .filter(n -> n.startsWith(prefix.toLowerCase()) || n.startsWith(prefix.toUpperCase()))
                .collect(Collectors.toList());
    }

    private static String sortAndGetFirst() {
        return names.stream()
                .sorted()
                .findFirst().orElse("Empty");
    }
}
