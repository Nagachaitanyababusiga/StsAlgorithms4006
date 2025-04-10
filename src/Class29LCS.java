import java.util.*;

public class Class29LCS{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        String res=LCS(a,b);
        System.out.println(res);
        sc.close();
    }
    public static String LCS(String a,String b){
        int m=a.length(),n=b.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char c1=a.charAt(i-1);
            for(int j=1;j<=n;j++){
                char c2=b.charAt(j-1);
                if(c1==c2){
                    int curr=dp[i-1][j-1]+1;
                    dp[i][j]=Math.max(dp[i][j],curr);
                }else{
                    int left=dp[i][j-1];
                    int top=dp[i-1][j];
                    dp[i][j]=Math.max(left,top);
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        int i=m,j=n;
        while(i>0&&j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                sb.insert(0,a.charAt(i-1));
                i--;
                j--;
            }else if (dp[i-1][j]>dp[i][j-1]) {
                i--;
            }else{
                j++; 
            }
        }
        return sb.toString();
    }
}