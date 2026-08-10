package com.interview.prep.dsa.programs;

public class NextPermutation {

    public static void nextPermutation(int [] a)
    {
        int len =a.length;
        int pivot=-1;
        for(int i=len-2;i>=0;i--){
            if(a[i]<a[i+1]){
                pivot=i;
                break;
            }
        }
        if (pivot!=-1) {
            for (int j = len - 1; j > pivot; j--) {
                if (a[j]>a[pivot]){
                    int temp=a[j];
                    a[j]=a[pivot];
                    a[pivot]=temp;
                    break;
                }
            }

        }
        reverse(a,pivot+1,len-1);

    }
    public static void reverse(int[] a, int start, int end){
        while(start<end){
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}
