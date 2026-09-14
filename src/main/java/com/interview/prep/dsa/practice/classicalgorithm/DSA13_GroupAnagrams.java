package com.interview.prep.dsa.practice.classicalgorithm;

import java.util.*;
import java.util.stream.Collectors;

public class DSA13_GroupAnagrams {

    public static void groupAnagramsUsingStream(String [] s){

        Collection<List<String>> list = Arrays.stream(s)
                        .collect(Collectors.groupingBy(
                                word-> {
                                 char [] c= word.toCharArray();
                                 Arrays.sort(c);
                                 return new String(c);
                                }
                        )).values();

        System.out.println(list);

    }

    public static void groupAnagramsUsingHashMap(String [] s){

        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : s){
            char [] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        System.out.println(map.values());
    }
}
