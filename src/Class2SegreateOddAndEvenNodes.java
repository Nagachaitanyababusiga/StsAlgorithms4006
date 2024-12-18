
import java.util.*;

//6->8->3->2->5

public class Class2SegreateOddAndEvenNodes {

    public static void print(Node head){
        while(head!=null){
            if(head.next!=null) System.out.print(head.val+" -> ");
            else System.out.println(head.val);
            head=head.next;
        }
        System.out.println();
    }

    public static Node computeUsingGeneral(Node head){
        Node Evenhead=null,Oddhead=null,Eventail=null,Oddtail=null;
        Node curr=head;
        while(curr!=null){
            if(curr.val%2==0){
                if(Evenhead==null){
                    Evenhead=Eventail=curr;
                }else{
                    Eventail.next=curr;
                    Eventail=Eventail.next;
                }
            }else{
                if(Oddhead==null){
                    Oddhead=Oddtail=curr;
                }else{
                    Oddtail.next=curr;
                    Oddtail=Oddtail.next;
                }
            }
            curr=curr.next;
        }
        if(Eventail!=null){
            Eventail.next=Oddhead;
        }
        if(Oddtail!=null){
            Oddtail.next=null;
        }
        return Evenhead;
    }

    public static Node computeUsingOptimal(Node head){
        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node head=null,tail=null;
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            if(head==null){
                head=new Node(a);
                tail=head;
            }else{
                tail.next=new Node(a);
                tail=tail.next;
            }
        }
        Node EvenAndOdd=computeUsingGeneral(head);
        print(EvenAndOdd);
        sc.close();
    }
}

class Node{
    Node next;
    int val;
    Node(int val){
        this.val=val;
    }
}