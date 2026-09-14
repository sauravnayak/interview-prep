package com.interview.prep.dsa.practice;

import java.util.HashMap;

public class DSA09_TwoIndicesForTargetSum {

    public static void getIndices(int [] a, int sum){

        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i =0;i<a.length;i++){
            int target = sum-a[i];
            if(hs.containsKey(target)){
                System.out.println("Indices are " + hs.get(target)+ " & "+ i);
            }
            hs.put(a[i],i);
        }
    }
}
