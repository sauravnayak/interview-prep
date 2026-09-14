package com.interview.prep.dsa.practice.classicalgorithm;

public class DSA10_MaximumSubarray {

    public static void maximumSubArray(int [] a){

        int currentSum = a[0];
        int maxSum=a[0];

        for(int i=1;i<a.length;i++){
            currentSum = Math.max(a[i],currentSum+a[i]);

            maxSum= Math.max(maxSum,currentSum);

        }
        System.out.println("The maximum sum is "+ maxSum);
    }
}
