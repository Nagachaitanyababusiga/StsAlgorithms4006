
/*
    shortest path from a node in the graph to the all other nodes in directed weighted graph
    starting from a particular source node.
*/

import java.util.*;

public class Class17DialsAlgorithm {
    //A=0,B=1,C=2,D=3,E=4
    public static void main(String[] args) {
        Map<Integer,List<int[]>> mp=new HashMap<>();

        // int distance[]=new int[5];
        int distance[]=new int[5];
        Arrays.fill(distance,Integer.MAX_VALUE);

        //example graph during explanation
        /*
        mp.put(0,new ArrayList<>());
        mp.get(0).add(new int[]{1,3});
        mp.get(0).add(new int[]{2,6});
        mp.get(0).add(new int[]{3,3});
        mp.put(1,new ArrayList<>());
        mp.get(1).add(new int[]{3,2});
        mp.put(2,new ArrayList<>());
        mp.get(2).add(new int[]{0,6});
        mp.get(2).add(new int[]{3,4});
        mp.get(2).add(new int[]{4,4});
        mp.put(3,new ArrayList<>());
        mp.get(3).add(new int[]{4,5});

        */

        /*
         Example
         0,1,2
         0,3,1
         1,2,3
         1,3,2
         3,4,4
         4,2,1
         start vertex = 0
         */

         mp.computeIfAbsent(0,k->new ArrayList<>()).add(new int[]{1,2});
         mp.computeIfAbsent(0,k->new ArrayList<>()).add(new int[]{3,1});
         mp.computeIfAbsent(1,k->new ArrayList<>()).add(new int[]{2,3});
         mp.computeIfAbsent(1,k->new ArrayList<>()).add(new int[]{3,2});
         mp.computeIfAbsent(3,k->new ArrayList<>()).add(new int[]{4,4});
         mp.computeIfAbsent(4,k->new ArrayList<>()).add(new int[]{2,1});

        compute(0,mp,distance);
        System.out.println(Arrays.toString(distance));

    }

    static void compute(int s,Map<Integer,List<int[]>> g,int distance[]){
        //[node,weight]
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{s,0});
        distance[s]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int val=curr[0];
            int weight=curr[1];
            for(int i[]:g.getOrDefault(val,new ArrayList<>())){
                if(weight+i[1]<distance[i[0]]){
                    pq.add(new int[]{i[0],weight+i[1]});
                    distance[i[0]]=weight+i[1];
                }
            }
        }
    }

}
