package com.interview.prep.dsa.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDupInArrayCount_DSA4 {
    public static void removeDuplicateInArray(int [] a){
        if(a==null || a.length==0){
            throw new IllegalArgumentException("Array is empty");
        }
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int n:a){
            if(map.containsKey(n)){
                map.put(n,map.getOrDefault(n,0)+1);
                map.put(n,map.get(n)+1);
            }
            else map.put(n,1);
        }
        for (int n: map.keySet()){
            System.out.println("The Key->"+n+ " Value->"+ map.get(n));
        }


    }

}
