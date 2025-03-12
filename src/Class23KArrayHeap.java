
//No programming questions only MCQs

import java.util.*;

public class Class23KArrayHeap {
    public static Node buildTree(int[] arr,int n,int i){
        if(i>=n||arr[i]==-1) return null;
        Node root=new Node(arr[i]);
        root.left=buildTree(arr, n, 2*i+1);
        root.right=buildTree(arr, n, 2*i+2);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Node root=buildTree(arr,n,0);
        print(root);
        sc.close();
    }
    public static void print(Node root){
        if(root==null) return;
        print(root.left);
        System.out.print(root.data+" ");
        print(root.right);
    }
}

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}