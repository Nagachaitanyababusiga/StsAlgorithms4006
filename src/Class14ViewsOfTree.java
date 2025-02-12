import java.util.*;

// Different views of a Tree
// left , right , top , bottom , horizontal , vertical

public class Class14ViewsOfTree {

    //left view
    public static void PrintLeftView(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==0) res.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        System.out.println(res);
    }

    //right view
    public static void PrintRightView(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==size-1) res.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        System.out.println(res);
    }


    //vertical view
    public static void PrintTopView(TreeNode root){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> mp=new HashMap<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            int hd=p.hd;
            TreeNode node=p.node;
            if(!mp.containsKey(hd)){
                mp.put(hd,node.val);
            }
            if(node.left!=null){
                q.add(new Pair(node.left, hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right, hd+1));
            }
        }
        for(int i:mp.keySet()) res.add(mp.get(i));
        System.out.println(res);
    }

    //horizantol view
    public static void PrintBottomView(TreeNode root){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> mp=new HashMap<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            int hd=p.hd;
            TreeNode node=p.node;
            mp.put(hd,node.val);
            if(node.left!=null){
                q.add(new Pair(node.left, hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right, hd+1));
            }
        }
        for(int i:mp.keySet()) res.add(mp.get(i));
        System.out.println(res);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(6);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.left.right=new TreeNode(7);
        PrintLeftView(root);
        PrintRightView(root);
        PrintTopView(root);
        PrintBottomView(root);
    }
}


/*

       1
    2       4  
 3    6   5
            7
*/

class TreeNode{
    TreeNode left,right;
    int val;
    TreeNode(int val){
        this.val=val;
    }
}

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node,int hd){
        this.node=node;
        this.hd=hd;
    }
}