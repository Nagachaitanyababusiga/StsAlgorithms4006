
public class Class13RecoverTheBST {

    public static TreeNode first,middle,last,prev;

    public static void correctBST(TreeNode root){
        first=middle=last=prev=null;
        correctBSTUtil(root);
        if(last==null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }else{
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
    }

    public static void correctBSTUtil(TreeNode root){
        if(root!=null){
            correctBSTUtil(root.left);
            if(prev!=null&&root.val<prev.val){
                if(first==null){
                    first=prev;
                    middle=root;
                }else{
                    last=root;
                }
            }
            prev=root;
            correctBSTUtil(root.right);
        }
    }

    public static void printInorder(TreeNode root){
        if(root==null) return;
        if(root.left!=null) printInorder(root.left);
        System.out.print(root.val +" -> ");
        if(root.right!=null) printInorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(6);
        t.left=new TreeNode(10);
        t.left.left=new TreeNode(1);
        t.left.right=new TreeNode(3);
        t.right=new TreeNode(2);
        t.right.left=new TreeNode(7);
        t.right.right=new TreeNode(12);
        printInorder(t);
        System.out.println();
        correctBST(t);
        printInorder(t);
        System.out.println();
    }
}

class TreeNode{
    TreeNode left,right;
    int val;
    TreeNode(int val){
        this.val=val;
    }
}
