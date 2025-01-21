import  java.util.*;

public class Class8StackPermutations {

    public  static boolean isStackPermutation(int[] o,int[] t){
        Stack<Integer> st=new Stack<>();
        int i=0;
        for(int ele: o){
            st.push(ele);
            while(!st.isEmpty()&&st.peek()==t[i]){
                st.pop();
                i++;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int original[]=new int[n];
        int target[]=new int[n];
        for(int i=0;i<n;i++){
            original[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            target[i]=sc.nextInt();
        }
        System.out.println(isStackPermutation(original,target));
        sc.close();
    }

}
