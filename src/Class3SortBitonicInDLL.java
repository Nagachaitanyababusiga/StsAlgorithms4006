
// 2 -> 3 -> 5-> 4 -> 1 -> 0
import java.util.*;

public class Class3SortBitonicInDLL {

    public static void main(String[] args) {
        DLLNode head=null,prev=null,tail=null;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            DLLNode curr=new DLLNode(a);
            if(head==null){
                head=curr;
                prev=curr;
                tail=head;
            }else{
                prev.next=curr;
                curr.prev=prev;
                prev=prev.next;
                tail=prev;
            }
        }
        // printForward(head);
        // printBackward(tail);
        computeAndPrint(head);
        sc.close();
    }

    public static void computeAndPrint(DLLNode head){
        if(head==null||head.next==null){
            printForward(head);
            return;
        }
        DLLNode IncreaseHead=head;
        DLLNode decreaseHead=head.next;
        while(IncreaseHead.next!=null&&decreaseHead.next!=null&&decreaseHead.val>IncreaseHead.val){
            IncreaseHead=IncreaseHead.next;
            decreaseHead=decreaseHead.next;
        }
        if(IncreaseHead!=null){
            IncreaseHead.next=null;
        }
        if(decreaseHead!=null){
            decreaseHead.prev=null;
        }
        IncreaseHead=head;
        decreaseHead=reverse(decreaseHead);
        printDetailed(merge(IncreaseHead,decreaseHead));
    }

    public static DLLNode merge(DLLNode inc,DLLNode dec){
        DLLNode dummy=new DLLNode(-1);
        DLLNode tail=dummy;
        while(inc!=null&&dec!=null){
            if(inc.val<dec.val){
                tail.next=inc;
                inc.prev=tail;
                inc=inc.next;
            }else{
                tail.next=dec;
                dec.prev=tail;
                dec=dec.next;
            }
            tail=tail.next;
        }
        while(inc!=null){
            tail.next=inc;
            inc.prev=tail;
            inc=inc.next;
            tail=tail.next;
        }
        while(dec!=null){
            tail.next=dec;
            dec.prev=tail;
            dec=dec.next;
            tail=tail.next;
        }
        tail.next=null;
        if(dummy.next!=null) dummy.next.prev=null;
        return dummy.next;
    }

    public static DLLNode reverse(DLLNode head){
        DLLNode prev=null;
        while(head!=null){
            DLLNode temp=head.next;
            head.next=prev;
            if(head.prev!=null) head.prev.prev=head;
            prev=head;
            head=temp;
        }
        if(prev!=null) prev.prev=null;
        return prev;
    }

    public static  void printForward(DLLNode head){
        while(head!=null){
            if(head.next!=null) System.out.print(head.val+" -> ");
            else System.out.println(head.val);
            head=head.next;
        }
        System.out.println();
    }

    public static  void printBackward(DLLNode head){
        while(head!=null){
            if(head.prev!=null) System.out.print(head.val+" -> ");
            else System.out.println(head.val);
            head=head.prev;
        }
        System.out.println();
    }

    public static void printDetailed(DLLNode head){
        while(head!=null){
            if(head.next==null&&head.prev==null) System.out.println("-1,"+head.val+",-1");
            else if(head.next!=null) System.out.print((head.prev==null)?"["+-1+","+head.val+","+head.next.val+"] -> ":"["+head.prev.val+","+head.val+","+head.next.val+"] -> ");
            else System.out.println((head.next==null)?"["+head.prev.val+","+head.val+","+-1+"]":"["+head.prev.val+","+head.val+","+head.next.val+"]");
            head=head.next;
        }
    }

}

class DLLNode{
    int val;
    DLLNode prev,next;

    DLLNode(int val) {
        this.val=val;
    }
    
}

