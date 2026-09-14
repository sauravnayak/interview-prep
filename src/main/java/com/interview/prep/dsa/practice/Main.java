package com.interview.prep.dsa.practice;

import com.interview.prep.dsa.practice.classicalgorithm.*;

public class Main {

    public static void main(String [] args){


        /** DSA-01  Find the Nth maximum (distinct) number in an array
         *         int [] a = new int[] {1,4,7,0,14};
         *         DSA01_FindNthMaximumInArray.getNthMaxUsingStack(a,6);
         */


        /** DSA-02  Find the Second maximum (distinct) number in an array without sorting
         *         int [] a = new int[] {1,4,7,0,14};
         *         DSA02_FindSecondMaximum.get2ndMax(a);
         */

        /** DSA-03  Reverse an array in place (two-pointer)
         *         int [] a = new int[] {1,4,7,0,14};
         *         DSA03_ReverseArrayInPlace.reverseArray(a);
         */

        /**   DSA-04  Remove duplicates from an array / return count
         *         #Using Stream
         *         int [] a = new int[] {1, 2, 2, 3, 4, 4, 5};
         *         DSA04_RemoveDuplicatesFromArray.removeDuplicatesUsingStream(a);
         *
         *         #Using hashSet
         *         int [] a = new int[] {1, 2, 2, 3, 4, 4, 5};
         *         DSA04_RemoveDuplicatesFromArray.removeDuplicatesUsingHashSet(a);
         *
         *         #Using HashMap and also printing frequency
         *         int [] a = new int[] {1, 2, 2, 3, 4, 4, 5};
         *         DSA04_RemoveDuplicatesFromArray.removeDuplicatesUsingHashMap(a);
         *
         *
         */

        /** DSA-05  Find missing number in 1..n
         *         int [] a = new int[] {1,2,3,4,6,7};
         *         DSA05_FindMissingNumberInSeries.findMissingSeries(a);
         */


        /**  DSA-06  Move all zeros to the end (keep order)
         *          #By Using Swap when Non-zero is found
         *         int [] a = new int[] {1,2,0,5,0,7};
         *         DSA06_MoveZeroesToEnd.moveZeroesToEnd(a);
         *
         *         #Without using swap we first fill non-zero and then zero
         *         int [] a = new int[] {1,2,0,5,0,7};
         *         DSA06_MoveZeroesToEnd.moveZeroesToEndWithoutSwap(a);
         */

        /**  DSA-07  Rotate array by k positions
         *         int [] a = new int[] {1,2,0,5,0,7};
         *         DSA07_RotateArraybyKPosition.rotateArrayByK(a,3);
         *
         */

        /**  DSA-09  Two Sum — indices of pair summing to target
         *         int [] a = new int [] {3,4,6,5,21,3,10};
         *         DSA09_TwoIndicesForTargetSum.getIndices(a,9);
         *
         */

        /**  DSA-10  Maximum subarray sum (Kadane's algorithm)
         *         int [] a = new int [] {2, 3, -8, 7, -1, 2, 3};
         *         DSA10_MaximumSubarray.maximumSubArray(a);
         *
         */


        /**   DSA-11  Binary search (iterative) + first/last occurrence
         *         int [] a = new int [] {2, 4,4,6,4,8,11};
         *         DSA11_BinarySearch.binarySearch(a,4);
         *
         */

        /**   DSA-12  Sliding window — max sum of k consecutive / longest substring without repeat
         *         int [] a = new int [] {2, 1, 5, 1, -3, 2};
         *         DSA12_MaximumSubArrayOfKSize.maximumSubarrayOfKSize(a,3);
         *
         */

        /**   DSA-13  Check anagram / group anagrams
         * in - ["eat","tea","tan","ate","nat","bat"]
         * out -[["bat"],["nat","tan"],["ate","eat","tea"]]
         *        #Using stream
         *       String [] a = new String[]  {"eat","tea","tan","ate","nat","bat"};
         *       DSA13_GroupAnagrams.groupAnagramsUsingStream(a);
         *
         */

        /**   DSA-13  Check anagram / group anagrams
         * in - ["eat","tea","tan","ate","nat","bat"]
         * out -[["bat"],["nat","tan"],["ate","eat","tea"]]
         *          #Using HashMap
         *         String [] a = new String[]  {"eat","tea","tan","ate","nat","bat"};
         *         DSA13_GroupAnagrams.groupAnagramsUsingHashMap(a);
         *
         */

        /**   DSA-14  String palindrome (ignore case/non-alnum)
         *         String s= "Too hot to hoot";
         *         DSA14_PalindromeCheck.checkPalindrome(s);
         *
         */

        /**   DSA-14  Check if String is valid parentheses (balanced)
         *         String s= "{}{}[{()}]";
         *         DSA14_ValidParanthesis.balancedParanthesis(s);
         */

        String s= "{}{}[{()}]";
        DSA14_ValidParanthesis.balancedParanthesis(s);
    }
}
