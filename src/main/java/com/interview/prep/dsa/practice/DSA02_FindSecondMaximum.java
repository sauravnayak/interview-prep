package com.interview.prep.dsa.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class DSA02_FindSecondMaximum {

    public static void get2ndMax(int [] a){

        int max = a[0];
        int secondMax=0;
        if(a.length<=2){
            throw  new IllegalArgumentException("The Array is of Less Size");
        }
        for (int j= 1; j<a.length;j++){
            if(a[j]>max){
                secondMax= max;
                max=a[j];
            }
            else if (a[j]>secondMax){
                secondMax= a[j];
            }
        }
        System.out.println(secondMax);
    }
}
