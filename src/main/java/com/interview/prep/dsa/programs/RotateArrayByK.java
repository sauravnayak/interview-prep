package com.interview.prep.dsa.programs;

import java.util.Arrays;

public class RotateArrayByK {
    public static void rotateArray(int [] a,int n){
        n = n % a.length;
        reverse(a,0,a.length-1);
        reverse(a,0,n-1);
        reverse(a,n,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static int [] reverse(int [] a,int left, int right){
        while(left<right){
            int temp =a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;
            right--;
        }
        return a;
    }
}
