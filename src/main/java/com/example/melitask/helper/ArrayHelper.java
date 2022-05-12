package com.example.melitask.helper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayHelper {

    public static String[] mergeArrays(List<String[]> inputArrays) {

        // Join the elements into a single list
        List<String> collect = inputArrays.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());

        // Join every th element in the list
        int size = collect.size() / inputArrays.size();
        List<String[]> result = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            result.add(getNthElement(inputArrays, i));
        }

        // Collect the result and return
        return result.stream()
                .flatMap(Stream::of)
                .toArray(String[]::new);
    }

    /**
     * Method to retrieve every th element from a collection
     * @param lists the lists to retrieve the elements from
     * @param nth the position of the element to retrieve
     * @return
     */
    private static String [] getNthElement(List<String[]> lists, int nth) {
        return lists.stream()
                .map(l -> l[nth])
                .filter(element -> !element.isBlank())
                .distinct()
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }

}
