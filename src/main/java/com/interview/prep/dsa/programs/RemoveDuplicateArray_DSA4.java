package com.interview.prep.dsa.programs;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateArray_DSA4 {

    public static void removeDuplicateInArray(int [] a){
        if(a==null || a.length==0){
            throw new IllegalArgumentException("Array is empty");
        }
        List<Integer> array= Arrays.stream(a)
                .boxed()
                .distinct()
                .toList();

        System.out.println(array);
    }
}
