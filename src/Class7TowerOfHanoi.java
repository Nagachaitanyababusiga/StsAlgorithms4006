import  java.util.*;

public class Class7TowerOfHanoi {

    public static void TOH(int n,int s,int a,int d){
        if(n==1){
            System.out.println("move disk 1 from "+s+" to "+d);
            return;
        }
        TOH(n-1, s, d, a);
        System.out.println("Move disk "+(n)+" from "+s+" to "+d);
        TOH(n-1, a, s, d);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int noOfDisks=sc.nextInt();
            int source=sc.nextInt();
            int auxilary=sc.nextInt();
            int destination=sc.nextInt();
            TOH(noOfDisks,source,auxilary,destination);
        }
    }

}
