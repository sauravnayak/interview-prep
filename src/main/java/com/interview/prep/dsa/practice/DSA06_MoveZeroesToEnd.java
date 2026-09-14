package com.interview.prep.dsa.practice;

import java.util.Arrays;

public class DSA06_MoveZeroesToEnd {
    public static void moveZeroesToEnd(int [] a){

        int lastIndex=0;
        // {1,2,0,5,0,7};

        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                int temp= a[i];
                a[i]=a[lastIndex];
                a[lastIndex]=temp;
                lastIndex++;
            }

        }
        System.out.println(Arrays.toString(a));
    }

    public static void moveZeroesToEndWithoutSwap(int [] a){

        int pos=0;

        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                a[pos++]=a[i];
            }
        }
        while(pos<a.length){
            a[pos++]=0;
        }

        System.out.println(Arrays.toString(a));
    }
}
