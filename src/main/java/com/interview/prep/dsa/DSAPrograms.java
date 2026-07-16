package com.interview.prep.dsa;


import com.interview.prep.dsa.programs.FindMissingNumber_DSA5;
import com.interview.prep.dsa.programs.MoveAllZeroes_End_DSA06;
import com.interview.prep.dsa.programs.RemoveDupInArrayCount_DSA4;
import com.interview.prep.dsa.programs.RotateArrayByK;

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

         */
        int [] arr= new int [] {1, 2, 3, 4, 5, 6};
        RotateArrayByK.rotateArray(arr,2);






    }
}
