import  java.util.*;

//Naive: TC:- O(N*K) SC:- O(N-K+1)
//Using SelfBalancing Tree: TC:- O(N*log(K)) SC:- O(K)
//Using PriorityQueue: TC:- O(N*log(K)) SC:- O(K)
//Using Dequeu: TC:- O(N) SC:- O(K)

public class Class11MaximumSlidingWindow {

    public static void computeMaxUsingBruteForce(int[] arr,int n,int k){
        int arrk[]=new int[n-k+1];
        int l=0;
        for(int i=0;i<=n-k;i++){
            int sum=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                sum=Math.max(sum,arr[j]);
            }
            arrk[l++]=sum;
        }
        System.out.println(Arrays.toString(arrk));
    }

    public static void computeMaxUsingDeque(int[] arr,int n,int k){
        int[] res=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&dq.peek()<i-k+1){
                dq.poll();
            }
            while(!dq.isEmpty()&&arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                res[i-k+1]=arr[dq.peek()];
            }
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=7;//sc.nextInt();
        int k=4;//sc.nextInt();
        int[] arr={5,3,2,4,7,8,9};//new int[n];
        // for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        computeMaxUsingBruteForce(arr,n,k);
        computeMaxUsingDeque(arr,n,k);
        sc.close();
    }
}
