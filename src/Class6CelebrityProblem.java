import java.util.*;

public class Class6CelebrityProblem {


    public static int findCelebrity(int[][] rel){
        int candidate=0;
        for(int i=0;i<rel.length;i++){
            if(rel[candidate][i]==1) candidate=i;
        }
        for(int i=0;i<rel.length;i++) if(i!=candidate&&(rel[candidate][i]==1||rel[i][candidate]==0)) return -1;
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of candidates: ");
        int n=sc.nextInt();
        int relations[][]=new int[n][n];
        System.out.println("The relation matrix is as follows: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                relations[i][j]=sc.nextInt();
            }
        }
        int celeb=findCelebrity(relations);
        if(celeb==-1){
            System.out.println("There is no celebrity");
        }else{
            System.out.println("The celebrity is : "+celeb);
        }
        sc.close();
    }


}
