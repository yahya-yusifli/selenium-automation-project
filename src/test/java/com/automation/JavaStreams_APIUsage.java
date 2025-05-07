package com.automation;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams_APIUsage {
    // Count the number of names starting with alphabet A in list

    @Test
    public void regular() {
        List<String> names = new ArrayList<String>();
        names.add("Aliyah");
        names.add("Don");
        names.add("Alex");
        names.add("Adam");
        names.add("Tony");

        int counter = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.startsWith("A")) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Aliyah");
        names.add("Don");
        names.add("Alex");
        names.add("Adam");
        names.add("Tony");

        // there is no life for intermediate operation, if there is no terminal operation.
        // terminal operation will execute only if inter operation(filter) return true.
        // we can create stream
        // how to use filter in Stream API
        long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        // print all the names of ArrayList
        names.stream().filter(s -> s.length() > 3).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 3).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void StreamMap() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("Don");
        names.add("women");

        // print names which have last letter as  'a' with Uppercase
        Stream.of("Aliyah", "aliyah", "Dina", "Alex", "Adam", "Toma").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        // print names which have first letter as a with Uppercase and sorted
        List<String> names1 = new ArrayList<>(Arrays.asList("Azliyah", "aliyah", "Dina", "Alex", "Adam", "Toma"));
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        // Mergin 2 different list
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        // newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }

    @Test
    public void streamCollect() {
        // create list
        List<String> list = Stream.of("Aliyah", "aliyah", "Dina", "Alex", "Adam", "Toma")
                .filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(list.get(0));


        List<Integer> values = new ArrayList<>(Arrays.asList(3,2,2,7,5,1,9,7));
        // Print unique members ( .distinct() )
        // values.stream().distinct().forEach(s-> System.out.println(s));

        // Sorted array 3rd index -1,2,3,5,7,9
        List<Integer> list1 = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list1.get(2));

    }

}
