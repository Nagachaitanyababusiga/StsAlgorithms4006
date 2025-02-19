
public class Class15BoundaryTraversal {

    public static void printLeftBoundary(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)) return;
        System.out.print(root.val+" ");
        if(root.left!=null) printLeftBoundary(root.left);
        else printLeftBoundary(root.right);
    }

    public static void printLeaves(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            System.out.print(root.val+" ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void printRightBoundary(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)) return;
        if(root.right!=null) printRightBoundary(root.right);
        else printRightBoundary(root.left);
        System.out.print(root.val+" ");
    }

    public static void boundaryTraversal(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(3);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(6);
        boundaryTraversal(root);
    }
}

class TreeNode 
{
    TreeNode left,right;
    int val;
    TreeNode(int val){
        this.val=val;
    }
}