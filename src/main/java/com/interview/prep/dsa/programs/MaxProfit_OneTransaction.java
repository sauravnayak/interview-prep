package com.interview.prep.dsa.programs;

public class MaxProfit_OneTransaction {

    public static int maximumProfit_ForOneTransaction(int [] a){
        if(a==null || a.length<2){
            return 0;
        }
        int lowest=a[0];
        int maxProfit=0;
        for(int i=1;i<a.length;i++){
            if (a[i]<lowest){
                lowest=a[i];
            }
            else if (a[i]-lowest>maxProfit)
            {
                maxProfit=a[i]-lowest;
            }
        }
    return maxProfit;
    }
}
