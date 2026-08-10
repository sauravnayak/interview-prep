package com.interview.prep.dsa.programs;

public class MaxProfit_MultipleTransaction {


    public static int maximumProfitForMultipleTransactions(int [] a){
        int profit=0;
        for(int i=1;i<a.length;i++){
            if (a[i]>a[i-1]){
                profit+=a[i]-a[i-1];
            }
        }
        return profit;
    }
}
