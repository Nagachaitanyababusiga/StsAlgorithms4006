import java.util.*;

public class Class1LoopDetection{
    public static void main(String[] args){
        Node one=new Node(1);
        Node two=new Node(2);
        Node three=new Node(3);
        Node four=new Node(4);
        Node five=new Node(5);
        one.next=two;
        two.next=three;
        three.next=four;
        three.next=five;
        five.next=one;
        System.out.println(computeUsingHash(one));
        System.out.println(computeUsingFloyd(one));
    }

    public static boolean computeUsingFloyd(Node head){
        Node slow=head;
        Node fast=head;
        do { 
            if(fast==null) return false;
            slow=slow.next;
            fast=fast.next.next;
        } while (slow!=fast);
        return true;
    }

    public static boolean computeUsingHash(Node head){
        Set<Integer> st=new HashSet<>();
        while(head!=null){
            if(st.contains(head.val)) return true;
            st.add(head.val);
            head=head.next;
        }
        return false;
    }

}

class Node{
    Node next;
    int val;
    Node(int val){
        this.val=val;
    }
}