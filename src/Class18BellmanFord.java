import java.util.*;

/*
    Example: (1,3,2) (4,3,-1) (2,4,1) (1,2,1) (0,1,5)
    Graph with negative weights (Dijistra's doesn't work)
    Example: (0,1,3) (1,2,-5) (3,1,6) (4,2,4) (5,4,3)
*/

public class Class18BellmanFord {
    public static void main(String[] args) {
        Map<Integer,List<int[]>> graph=new HashMap<>();
        int n=5;
        /*
        for(int i=0;i<n;i++) graph.put(i,new ArrayList<>());
        graph.get(1).add(new int[]{3,2});
        graph.get(4).add(new int[]{3,-1});
        graph.get(2).add(new int[]{4,1});
        graph.get(1).add(new int[]{2,1});
        graph.get(0).add(new int[]{1,5});
        */
        int edges[][]=new int[][]{{1,3,2},{4,3,-1},{2,4,1},{1,2,1},{0,1,5}};
        compute(edges,n);
    }

    public static void compute(int[][] edges,int n){
        int dist[]=new int[n];
        Arrays.fill(dist,(int)1e8);
        dist[0]=0;
        for(int i=0;i<n;i++){
            for(int e[]:edges){
                if((dist[e[0]]!=(int)1e8)&&dist[e[1]]>dist[e[0]]+e[2]){
                    if(i==n-1){
                        System.out.println("There is a negative weighted cycle");
                        return;
                    }
                    dist[e[1]]=dist[e[0]]+e[2];
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

}

