package com.interview.prep.dsa.programs;

import java.util.Arrays;

public class MoveAllZeroes_End_DSA06 {

    public static void moveAllZeroes(int [] a){
        int j=0;
        for (int i=0;i<a.length;i++){
            if (a[i]!=0){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
            }
        }
    System.out.println(Arrays.toString(a));
    }
}
