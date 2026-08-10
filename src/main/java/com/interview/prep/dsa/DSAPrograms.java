package com.interview.prep.dsa;


import com.interview.prep.dsa.programs.*;

import java.util.Arrays;
import java.util.Map;

/**

 * n = 1 returns the maximum, n = 2 the second maximum, and so on.
 * Approach: TreeSet auto-sorts and de-duplicates; walk it in descending order.
 * Complexity: O(m log m) time, O(m) space (m = number of elements).
 */
public class DSAPrograms {


    public static void main(String[] args) {
        /*
        DSA-01 — Find the Nth maximum (distinct) number in an array.

        int [] arr= new int[]{4, 2, 9, 9, 7, 1};
        NthMax.returnNthMax(arr,2 );
         */

        /*
        DSA-04: Remove Duplicates from an Array
        int [] arr= new int[]{1, 2, 2, 3, 4, 4, 5, 9, 9};
        RemoveDuplicateArray_DSA4.removeDuplicateInArray(arr);
         */


        /*
        DSA-04.2: Remove Duplicates from an Array and print count
        int [] arr= new int[]{1, 2, 2, 3, 4, 4, 5, 9, 9};
        RemoveDupInArrayCount_DSA4.removeDuplicateInArray(arr);
         */

        /*
        DSA-05 Find the Missing Number
        Given an array arr[] of size n-1 with distinct integers in the range of [1, n].
        This array represents a permutation of the integers from 1 to n with one element missing.
        Find the missing element in the array.
        Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
        Output: 6
        Explanation: All the numbers from 1 to 8 are present except 6.
         int [] arr= new int [] {8,2,4,5,3,7,1};
        FindMissingNumber_DSA5.findMissingNumber(arr);
         */

        /* DSA-06 -Move All Zeroes to End
        Given an array of integers arr[], move all the zeros to the
        end of the array while maintaining the relative order of all non-zero elements.
        Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
        Output: [1, 2, 4, 3, 5, 0, 0, 0]
        Explanation: There are three 0s that are moved to the end.
        int [] arr= new int [] {1, 2, 0, 4, 3, 0, 5, 0};
        MoveAllZeroes_End_DSA06.moveAllZeroes(arr);
         */

        /* DSA-07 Array after k Rotations
        Input: arr[] = [1, 2, 3, 4, 5, 6], k = 2
        Output: [5, 6, 1, 2, 3, 4]
        Input: arr[] = [1, 2, 3, 4, 5], k = 4
        Output: [2, 3, 4, 5, 1]

        int [] arr= new int [] {1, 2, 3, 4, 5, 6};
        RotateArrayByK.rotateArray(arr,2);

         */

        /* DSA-08 Counting frequencies of array elements
         Given an array arr[] of non-negative integers which may contain duplicate elements.
         Return the frequency of each distinct element present in the array.
         Examples:

         Input:  arr[] = [10, 20, 10, 5, 20]
         Output: [[5, 1], [10, 2], [20, 2]]
         Explanation: Here 5 occurs once, 10 occurs 2 times and 20 occurs 2 times
         int [] arr= new int [] {10, 20, 10, 5, 20};
         Frequency_InArray_DSA08.printFrequency(arr);
         */


        /* Write a program to find Next Permutation
        Input: arr[] = [2, 4, 1, 7, 5, 0]
        Output: [2, 4, 5, 0, 1, 7]
        int[] example = {3, 2, 1};
        System.out.println("Original: " + Arrays.toString(example));
        NextPermutation.nextPermutation(example);
        System.out.println("Next:     " + Arrays.toString(example));
         */

        /* Write a program to Majority Element - More Than n/3
        Input: arr[] = [2, 2, 3, 1, 3, 2, 1, 1]
        Output: [1, 2]
        Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).
        int [] example = {2, 2, 3, 1, 3, 2, 1, 1};
        MajorityFloorElements.majorityElementN3(example);

         */

        /* Write a Program to find profit -Stock Buy and Sell – Multiple Transaction Allowed
        int [] example = {100, 180, 260, 310, 40, 535, 695};
        System.out.println("The Profit Analysed is :"+ MaxProfit_MultipleTransaction.maximumProfitForMultipleTransactions(example));
         */

        /* Write a Program to find profit -Stock Buy and Sell – Only one Transaction Allowed
        int [] example = {7, 10, 1, 3, 6, 9, 2};
        System.out.println("The Profit Analysed is :"+ MaxProfit_OneTransaction.maximumProfit_ForOneTransaction(example));
         */

        int [] example = {1, 3, 6, 9, 11};
        System.out.println("The Profit Analysed is :"+ MaxProfit_OneTransaction.maximumProfit_ForOneTransaction(example));


    }
}
