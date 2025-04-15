
class Class32RodCuttingProblem{
    public static void main(String[] args){
        int[] price=new int[]{1,5,7,8,9,10,12,15,16,18};
        int n=price.length;
        int ans=compute(price,n);
        System.out.println(ans);
    }
    public static int compute(int[] price,int n){
        int cost[]=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                int news=j;
                int newe=i-j;
                cost[i]=Math.max(cost[i],price[news]+price[newe-1]);
            }
        }
        return cost[n];
    }
}
