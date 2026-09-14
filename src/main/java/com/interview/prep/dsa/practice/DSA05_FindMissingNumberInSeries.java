package com.interview.prep.dsa.practice;

import java.util.Arrays;

public class DSA05_FindMissingNumberInSeries {

    public static  void findMissingSeries(int [] a){

        long actualsum = Arrays.stream(a)
                .sum();
        long len = a.length;// 6
        long supposedSum = (len+1)* (len+2)/2;

        System.out.println(supposedSum-actualsum);

    }
}
