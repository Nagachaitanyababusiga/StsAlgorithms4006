
/*
 [1,2,3,1,1,2] :- 1=Munch 2=five-Star 3=Kitkat
 K=2

 */

public class Class27DistributingItemsWhenAPersonCanNotTAkeMoreThanTwoItemsOfSameType {
    public static boolean checkCount(int[] nums,int n,int k){
        int count;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==nums[i]) count++;
                if(count>2*k) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkCount(new int[]{1,1,2,3,1},5,2));
    }
}
