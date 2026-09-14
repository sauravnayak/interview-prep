package com.interview.prep.dsa.practice;

import java.util.*;

public class DSA01_FindNthMaximumInArray {

    public static void getNthMax(int [] a , int placement){

        Optional<Integer> n = Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(placement-1)
                .findFirst();

        if(n.isPresent()){
            System.out.println(n.get());
        }
        else  {
            System.out.println("not present");
        }
    }

    public static void getNthMaxUsingStack(int [] a , int placement){

        TreeSet<Integer> tree = new TreeSet<>(Comparator.reverseOrder());
        for (int k : a){
            tree.add(k);
        }
        while(placement>1){
            tree.pollFirst();
            placement--;
        }
        if(!tree.isEmpty()) {
            System.out.println(tree.getFirst());
        }
        else
            System.out.println("The array doesn't have ");
    }
}
