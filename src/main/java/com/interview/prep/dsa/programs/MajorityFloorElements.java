package com.interview.prep.dsa.programs;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MajorityFloorElements {

    public static void majorityElementN3(int[] a) {
        int len = a.length;
        int floor = len / 3;

        ArrayList<Integer> sol = new ArrayList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        for (int i : a) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > floor) {
                sol.add(entry.getKey());
            }
        }
        System.out.println(sol);
    }
}
