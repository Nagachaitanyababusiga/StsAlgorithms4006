import  java.util.*;

public class Class16BFSAndDFSOnGraph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /*
        0,1
        0,2
        1,2
        2,0
        2,3
        3,3
        */
        int n=4;//sc.nextInt();
        Map<Integer,List<Integer>> adjlst=new HashMap<>();
        for(int i=0;i<n;i++) adjlst.put(i,new ArrayList<>());
        adjlst.get(0).add(1);
        adjlst.get(0).add(2);
        adjlst.get(1).add(2);
        adjlst.get(2).add(0);
        adjlst.get(2).add(3);
        adjlst.get(3).add(3);
        boolean[] visited=new boolean[4];
        BFS(adjlst,visited,2);
        Arrays.fill(visited,false);
        DFS(adjlst,visited,2);
        sc.close();
    }

    public static void BFS(Map<Integer,List<Integer>> adjlst,boolean[] visited,int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        System.out.println(start+" ");
        visited[start]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                int curr=q.poll();
                for(int i:adjlst.getOrDefault(curr,new ArrayList<>())){
                    if(visited[i]) continue;
                    System.out.print(i+" ");
                    q.add(i);
                    visited[i]=true;
                }
            }
            System.out.println();
        }
    }

    public static void DFS(Map<Integer,List<Integer>> adjlst,boolean[] visited,int start){
        visited[start]=true;
        System.out.print(start+" ");
        for(int i:adjlst.getOrDefault(start, new ArrayList<>())){
            if(visited[i]) continue;
            visited[i]=true;
            DFS(adjlst,visited,i);
        }
    }

}
