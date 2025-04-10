import java.util.*;

class Class31LongestPalindromicSubsequence{
    static int dp[][];
    public static void main(String[] args){
        String s="ABCDAA";
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        //memoization
        int val=LPSS(s,0,s.length()-1);
        System.out.println(val);
        //tabulation
        val=LPSSUsingTabulation(s, n);
        System.out.println(val);
    }
    // Tabulation
    public static int LPSSUsingTabulation(String st,int n){
        int[][] table=new int[n+1][n+1];
        for(int i=0;i<n;i++) table[i][i]=1;
        for(int len=2;len<=n;len++){
            for(int s=0;s<=n-len;s++){
                int e=s+len-1;
                if(st.charAt(s)==st.charAt(e)) table[s][e]=2+table[s+1][e-1];
                else table[s][e]=Math.max(table[s+1][e],table[s][e-1]);
            }
        }
        return table[0][n-1];
    }
    // Memoization
    public static int LPSS(String st,int s,int e){
        if(e<s) return 0;
        if(e==s) return 1;
        if(dp[s][e]!=-1) return dp[s][e];
        if(st.charAt(s)==st.charAt(e)) return dp[s][e]=2+LPSS(st,s+1,e-1);
        return dp[s][e]=Math.max(LPSS(st,s+1,e),LPSS(st,s,e-1));
    }
}