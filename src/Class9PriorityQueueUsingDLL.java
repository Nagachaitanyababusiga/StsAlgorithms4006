import  java.util.*;

public class Class9PriorityQueueUsingDLL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sc.close();
    }
}

class DLLNode{

    int data;
    DLLNode prev,nxt;
    int priority;

    DLLNode rear,front;

    DLLNode(int data,int priority){
        this.data=data;
        this.priority=priority;
    }

    void  insert(int d,int p){
        DLLNode newNode=new DLLNode(d, p);
        if(front==null){
            
        }
    }

    @Override
    public String toString(){
        return "["+data+" - "+priority+"]";
    }

}