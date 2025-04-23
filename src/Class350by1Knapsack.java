import  java.util.*;

public class Class350by1Knapsack{
    // values=[100,200,150]
    // weights=[20,20,30]
    public static int knapsack(int[] wt,int[] val,int W,int n){
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0||w==0) dp[i][w] = 0;
                else if(wt[i-1]<=w) dp[i][w] = Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                else dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] val = {60,100,200};
        int[] wt = {10,20,30};
        int W = 50;
        int n = val.length;
        System.out.println("Maximum value = " + knapsack(wt,val,W,n));
        int[][] dp=new int[n+1][W+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        int ans=compute(0, W, val, wt, dp);
        System.out.println(ans);
    }
    static int compute(int i,int w,int val[],int wt[],int dp[][]){
        if(i>=val.length) return 0;
        if(w==0) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
        int take=0;
        if(w>=wt[i]){
            take=val[i]+compute(i+1,w-wt[i],val,wt,dp);
        }
        int nottake=compute(i+1,w,val,wt,dp);
        return dp[i][w]=Math.max(take,nottake);
    }
}