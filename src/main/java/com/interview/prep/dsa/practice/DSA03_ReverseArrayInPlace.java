package com.interview.prep.dsa.practice;

import java.util.Arrays;

public class DSA03_ReverseArrayInPlace {

    public static void reverseArray(int [] a){

        System.out.println("The Array before reverse is "+ Arrays.toString(a));
        int left = 0 ;
        int right = a.length-1;
        int [] res = new int[a.length];
        while(left<right){
            int temp = a[left];
            a[left]= a[right];
            a[right]= temp;
            left++;
            right--;
        }

        /* This method can also be used if we don't want 2 pointer mechanism
        int i =0;
        for(int j=right;j>=0;j--){
            res[i]=a[j];
            i++;
        }
         */
        System.out.println("The Array after reverse is : "+ Arrays.toString(a));
    }
}
