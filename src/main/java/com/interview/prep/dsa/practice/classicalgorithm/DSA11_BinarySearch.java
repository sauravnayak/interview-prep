package com.interview.prep.dsa.practice.classicalgorithm;

public class DSA11_BinarySearch {
    public static void binarySearch(int [] a, int n){

        int low =0 ;
        int high = a.length-1;
        int result =-1;

        //this is upper bound solution
        while(low<=high){
            int mid = low +(high-low)/2;
            if(a[mid]==n){
                result=mid;
                low=mid+1;
            }
            else if(a[mid]<n){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        System.out.println("Found at -> "+result);

        /*
        Lower bound if a[mid] == temp
        then high = mid-1

        higher bound if a[mid] == temp
        then low = mid+1

         */
    }
}
