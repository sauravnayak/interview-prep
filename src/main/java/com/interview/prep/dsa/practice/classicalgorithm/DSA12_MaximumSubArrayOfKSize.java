package com.interview.prep.dsa.practice.classicalgorithm;

public class DSA12_MaximumSubArrayOfKSize {

    public static void maximumSubarrayOfKSize(int [] a , int size){
        int currentsum =0;

        for(int i=0;i<size;i++){
            currentsum+=a[i];
        }

        int maxsum = currentsum;

        for(int j=size;j<a.length;j++){
            currentsum+= a[j]-a[j-size];
            maxsum=Math.max(currentsum,maxsum);
        }
        System.out.println("The Maximum subarray is-> "+ maxsum);

    }
}
