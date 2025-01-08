//

import java.util.*;

//methods :- push,pop,getmin,top

//[0,1]
//-3,0

public class Class5MinimumStack {

    Stack<Integer> MainStack,MinStack;

    Class5MinimumStack(){
        MainStack=new Stack<Integer>();
        MinStack=new Stack<Integer>();
    }

    void push(int ele){
        if(MinStack.isEmpty()||MinStack.peek()>=ele) MinStack.push(ele);
        MainStack.push(ele);
    }

    int pop(){
        if(MainStack.isEmpty()) return -1;
        if(MainStack.peek().equals(MinStack.peek())) MinStack.pop();
        return MainStack.pop();
    }

    int getMin(){
        if(MinStack.isEmpty()) return -1;
        return MinStack.peek();
    }

    int top(){
        if(MainStack.isEmpty()) return -1;
        return MainStack.peek();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Class5MinimumStack c=new Class5MinimumStack();
        c.push(5);
        c.push(15);
        c.push(-5);
        c.push(50);
        c.pop();
        c.push(-15);
        System.out.println(c.getMin());
        c.push(5);
        c.pop();
        c.pop();
        System.out.println(c.getMin());
        c.pop();
        System.out.println(c.getMin());
        sc.close();
    }
}
