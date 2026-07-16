package com.interview.prep.dsa;

import java.util.*;

public class NthMax {

    public static int returnNthMax(int [] a , int n){
        //System.out.println(nthMax(new int[]{4, 2, 9, 9, 7, 1}, 2))
        if(a==null|| a.length==0){
            throw new IllegalArgumentException("the Array is empty");
        }
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int num:a){
            set.add(num);
        }
        Optional<Integer> op= set.stream()
                .distinct()
                .skip(n-1)
                .findFirst();

        if (op.isPresent()){
            System.out.println(op.get());
            return op.get();

        }
        else
            throw new IllegalArgumentException("n out of range: ");


    }
}
