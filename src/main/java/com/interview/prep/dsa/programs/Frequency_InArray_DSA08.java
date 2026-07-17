package com.interview.prep.dsa.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class Frequency_InArray_DSA08 {

    public static void printFrequency(int [] a){
        //new int [] {10, 20, 10, 5, 20};

        Map<Integer,Integer> hashMap= new LinkedHashMap<>();
        for (int k: a){
            hashMap.put(k,hashMap.getOrDefault(k,0)+1);
        }
        for (int mapEle: hashMap.keySet()){
            System.out.println("Element: " + mapEle + " |Frequency: " + hashMap.get(mapEle));


            /*Use below statement only if you want frequency >1
            if(hashMap.get(mapEle)>1) {
                System.out.println("Element: " + mapEle + " |Frequency: " + hashMap.get(mapEle));
            }
             */
        }
    }

}
