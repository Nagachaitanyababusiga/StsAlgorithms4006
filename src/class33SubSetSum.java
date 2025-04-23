import java.util.*;

public class class33SubSetSum {
    static int dp[][];
    public static void main(String[] args) {
        int[] nums=new int[]{5,2,3,4,7};
        int n=nums.length;
        int tar=9;
        dp=new int[n+1][tar+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        boolean isPossible=(compute(0,nums,tar)==1);
        System.out.println(isPossible);
    }
    public static int compute(int i,int[] nums,int tar){
        if(tar==0) return 1;
        if(i==nums.length) return 0;
        if(dp[i][tar]!=-1) return dp[i][tar];
        if(nums[i]<=tar) if(compute(i+1,nums,tar-nums[i])==1) return dp[i][tar]=1;
        if(compute(i+1,nums,tar)==1) return dp[i][tar]=1;
        return dp[i][tar]=0;
    }
}
