package com.interview.prep.dsa.programs;

import java.util.Arrays;

public class FindMissingNumber_DSA5 {
    public static void findMissingNumber(int [] a){
        if(a==null || a.length==0){
            throw new IllegalArgumentException("Array is empty");
        }
        int len=a.length;
        int supposedSum=(len+1)*(len+2)/2;
        int sum= Arrays.stream(a)
                .sum();
        System.out.println("The missing value is:" +(supposedSum-sum));
    }
}
