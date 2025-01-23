
import java.util.*;

public class Class10SortWithoutExtraSpace {

    public static void sortWithoutExtraSpace(Queue<Integer> q){
        int n=q.size();
        for(int i=0;i<n;i++){
            int minIndex=-1;
            int minValue=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                int currValue=q.poll();
                if(currValue<minValue&&j<(n-i)){
                    minIndex=j;
                    minValue=currValue;
                }
                q.add(currValue);
            }
            for(int j=0;j<n;j++){
                int currValue=q.poll();
                if(j!=minIndex){
                    q.add(currValue);
                }
            }
            q.add(minValue);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n=sc.nextInt();
        Queue<Integer> q=new LinkedList<>();
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++) q.add(sc.nextInt());
        sortWithoutExtraSpace(q);
        System.out.println(q);
        sc.close();
    }

}
