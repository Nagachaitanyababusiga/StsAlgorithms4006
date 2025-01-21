import java.util.*;

//example: [100,70,60,80,20,25]
//span: [1,1,1,3,1,2]

public class Class8StockSpanProblem {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(computeSpan(arr)));
        sc.close();
    }

    public static int[] computeSpan(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            res[i]=st.isEmpty()?(i+1):(i-st.peek());
            st.push(i);
        }
        return res;
    }

}
