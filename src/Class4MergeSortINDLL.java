import java.util.*;

public class Class4MergeSortINDLL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of nodes");
        int n=sc.nextInt();
        System.out.println("Enter the nodes in order:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(Arrays.toString(arr));
        DLLNode head=null,prev=null;
        for(int i:arr){
            DLLNode curr=new DLLNode(i);
            if(head==null){
                head=curr;
            }else{
                prev.next=curr;
                curr.prev=prev;
            }
            prev=curr;
        }
        printDetailed(dLLmergeSort(head));
        sc.close();
    }

    public static DLLNode dLLmergeSort(DLLNode head){
        if(head==null||head.next==null) return head;
        DLLNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.prev.next=null;
        slow.prev=null;
        DLLNode first=dLLmergeSort(head);
        DLLNode second=dLLmergeSort(slow);
        return merge(first,second);
    }

    public static DLLNode merge(DLLNode first,DLLNode second){
        if(second==null) return first;
        if(first==null) return second;
        DLLNode head=null;
        DLLNode tail=head;
        DLLNode firsttail=first,secondtail=second;
        while(firsttail!=null&&secondtail!=null){
            if(head==null){
                if(firsttail.val<secondtail.val){
                    head=firsttail;
                    firsttail=firsttail.next;
                    tail=head;
                }else{
                    head=secondtail;
                    secondtail=secondtail.next;
                    tail=head;
                }
            }else{
                if(firsttail.val<secondtail.val){
                    tail.next=firsttail;
                    firsttail.prev=tail;
                    firsttail=firsttail.next;
                }else{
                    tail.next=secondtail;
                    secondtail.prev=tail;
                    secondtail=secondtail.next;
                }
                tail=tail.next;
            }
        }
        while(firsttail!=null){
            tail.next=firsttail;
            firsttail.prev=tail;
            firsttail=firsttail.next;
            tail=tail.next;
        }
        while(secondtail!=null){
            tail.next=secondtail;
            secondtail.prev=tail;
            secondtail=secondtail.next;
            tail=tail.next;
        }
        return head;
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

