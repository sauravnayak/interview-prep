package com.interview.prep.dsa.practice;

import java.util.*;
import java.util.stream.Collectors;

public class DSA04_RemoveDuplicatesFromArray {

    public static void removeDuplicatesUsingStream(int [] a){
        System.out.println("The Array before duplicate is : "+ Arrays.toString(a));
        List<Integer> res = Arrays.stream(a)
                .distinct()
                .boxed()
                .collect(Collectors.toList());

        System.out.println("The Array without dup is :"+ Arrays.toString(res.toArray()));
    }

    public static void removeDuplicatesUsingHashSet(int [] a){
        System.out.println("The Array before duplicate is : "+ Arrays.toString(a));
        Set<Integer> hs = new LinkedHashSet<>();
        for(int k:a){
            hs.add(k);
        }

        System.out.println("The Array without dup is :"+ Arrays.toString(hs.toArray()));
    }

    public static void removeDuplicatesUsingHashMap(int [] a){
        System.out.println("The Array before duplicate is : "+ Arrays.toString(a));
        Map<Integer,Integer> hm = new LinkedHashMap<>();
        for(int k:a){
            hm.put(k,hm.getOrDefault(k,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue()>0){
                System.out.println(entry.getKey() +" Frequency is: -> "+ entry.getValue());
            }
        }

    }
}
