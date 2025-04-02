import java.util.*;

public class Class25Practice{
    public static void main(String[] args){
        Graph g=new Graph(13);
        g.add(10,12);
        g.add(2,3);
        g.printGraph();
    }
}

class Graph{
    LinkedList<Integer> aList[];
    @SuppressWarnings("unchecked")
    Graph(int v){
        aList=new LinkedList[v];
        for(int i=0;i<v;i++) aList[i]=new LinkedList<>();
    }
    void add(int src,int dest){
        aList[src].add(dest);
        aList[dest].add(src);
    }
    void printGraph(){
        for(LinkedList<Integer> i:aList){
            System.out.println(i);
        }
    }
}