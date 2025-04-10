import java.util.*;

class class30LIS{
    public static void main(String args[]){
        int arr[]=new int[]{10,22,9,33,21,50,41,60};
        System.out.println(getLIS(arr));
    }
    public static int getLIS(int[] nums){
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++) if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],1+dp[j]);
        }
        int max=1;
        for(int i:dp) max=Math.max(max,i);
        return max;
    }
}