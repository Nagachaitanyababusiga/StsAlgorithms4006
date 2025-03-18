import java.util.*;

public class Class24Practice {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root=buildTree(arr,0,n);
        printrview(root);
        sc.close();
    }
    public static void printrview(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                if(i==s-1) System.out.print(curr.val+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
    public static void print(TreeNode root){
        if(root==null) return;
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    public static TreeNode buildTree(int[] arr,int i,int n){
        if(i>=n||arr[i]==-1) return null;
        TreeNode root=new TreeNode(arr[i]);
        root.left=buildTree(arr,2*i+1,n);
        root.right=buildTree(arr, 2*i+2, n);
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int d){
        val=d;
        left=right=null;
    }
}