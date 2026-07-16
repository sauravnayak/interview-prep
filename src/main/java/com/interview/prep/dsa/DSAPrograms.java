package com.interview.prep.dsa;

/**

 * n = 1 returns the maximum, n = 2 the second maximum, and so on.
 * Approach: TreeSet auto-sorts and de-duplicates; walk it in descending order.
 * Complexity: O(m log m) time, O(m) space (m = number of elements).
 */
public class DSAPrograms {


    public static void main(String[] args) {
        /*
        DSA-01 — Find the Nth maximum (distinct) number in an array.
         */
        int [] arr= new int[]{4, 2, 9, 9, 7, 1};
        NthMax.returnNthMax(arr,2 );
    }
}
