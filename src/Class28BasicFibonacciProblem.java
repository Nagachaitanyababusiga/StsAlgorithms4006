import  java.util.*;
// fibonacci series: 0 1 1 2 3 5 8 13

public class Class28BasicFibonacciProblem {
    //top down approach
    //recursion
    public static int topDown(int n,int[] memo){
        if(n<=1) return n;
        if(memo[n]!=-1) return memo[n];
        return memo[n]=topDown(n-1,memo)+topDown(n-2, memo);
    }
    //bottom up approach
    //iterative or tabulation
    public static int bottomUp(int n){
        if(n<=1) return n;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=10;
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        System.out.println(topDown(n, memo));
        System.out.println(bottomUp(n));
    }
}