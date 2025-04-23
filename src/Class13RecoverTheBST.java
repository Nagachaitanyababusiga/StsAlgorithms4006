
public class Class13RecoverTheBST {

    public static TreeNode prev,middle,first,last;

    public static void correctBST(TreeNode root){
        prev=middle=first=last=null;
        //initializing all the pointers with null value
        //first pointer will always be non null
        //check if the last pointer is null if so then swap first and middle pointer
        //else swap the first and last pointer
        correctBSTUtil(root);
        //recover the BST using correctBSTUtil method
        //if last is null that means that there is only one wrongly placed node
        if(last==null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }else{
            // this implies that there are more than one wrongly placed node
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
    }

    public static void correctBSTUtil(TreeNode root){
        // if root is null just return;
        if(root==null) return;
        //as in inorder first visit the left tree
        correctBSTUtil(root.left);
        //correct the BST
        //if the prev node is not null and prev nodes' value is greater than 
        //current node value then that is wrong so correct it.
        if(prev!=null&&prev.val>root.val){
            //The first wrong node is found
            //now mark it as first wrong node(prev node) and also assign the current node to 
            //middle node
            if(first==null){
                first=prev;
                middle=root;
            }else{
                //this is latter wrong nodes just update the last wrong node
                //when ever you find a wrong node
                last=root;
            }
        }
        //now the current Node becomes previous Node for next iteration
        prev=root;
        //later visit the right tree
        correctBSTUtil(root.right);
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
