package com.interview.prep.dsa.practice.classicalgorithm;

public class DSA14_PalindromeCheck {

    public static void checkPalindrome(String s ){

        s = s.replaceAll("\s+","").trim().toLowerCase();
        int start =0;
        int end = s.length()-1;
        while (start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                System.out.println("Not Palindrome");
                return;
            }
            start++;
            end--;
        }
        System.out.println("Palindrome");
    }
}
