package com.interview.prep.dsa.practice;

import java.util.Arrays;

public class DSA07_RotateArraybyKPosition {

    public static  void rotateArrayByK(int [] a , int k){
        System.out.println("The Array without rotation is :"+ Arrays.toString(a));

        int len= a.length-1;
        // {1,2,0,4}; {4,1,2,0}
        // {4,0,2, 1} {4, 1,2,0}
        rotate(a,0,len);
        rotate(a,0,k-1);
        rotate(a,k,len);
        System.out.println(Arrays.toString(a));


    }
    public static int [] rotate(int [] a, int start, int end){

        while(start<end){
            int temp =a[start];
            a[start]= a[end];
            a[end]= temp;
            start++;
            end--;
        }
        return a;
    }
}
