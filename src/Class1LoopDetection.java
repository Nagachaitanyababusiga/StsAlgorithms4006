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
        //Taking input
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node head=null,tail=null;
        Map<Integer,Node> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int curr=sc.nextInt();
            if(mp.keySet().contains(curr)){
                tail.next=mp.get(curr);
                tail=tail.next;
                continue;
            }
            if(head==null){
                head=new Node(curr);
                mp.put(curr,head);
                tail=head;
            }else{
                tail.next=new Node(curr);
                tail=tail.next;
                mp.put(curr,tail);
            }
        }
        System.out.println(computeUsingFloyd(head));
        System.out.println(computeUsingHash(head));
    }

    public static boolean computeUsingFloyd(Node head){
        Node slow=head;
        Node fast=head;
        do { 
            if(fast==null||fast.next==null) return false;
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