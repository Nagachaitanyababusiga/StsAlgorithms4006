import java.util.*;
/*
    Random order of elements 
    follow Hash table order
    Null elements are accepted
 */

 /*
    HashSet:- normal set
    Linked Hash set:- iterative order 
    Tree Set:- Follows red black tree,  null elements are not accepted and sorted keys
  */

  /*
    PREDEFINED METHODS:-
    1. Adding elements into a set :- .add(int element);
    2. Removing elements from a set:- .remove(ele);
    3. Check if Set contains the element or not:- .contains(ele);
    4. size of the set:- .size();
    5. Checking if the set is empty or not:- .isEmpty();
    6. Iterating Over Elements in a Set:- for each loop or an iterator
    7. Clearing the set: st.clear();
    8. Set union, Intersection, and difference (
     Union: set1.addAll(set2);
     Intersection: set1.retainAll(set2);
     Difference: st1.removeAll(set2));
  */

public class Class27Set {
    public static void main(String[] args) {
        //Set
        Set<Integer> hashSet=new HashSet<>();
        //Linked has Set
        Set<Integer> lhSet=new LinkedHashSet<>();
        //Tree Set
        Set<Integer> TSet=new TreeSet<>();

        System.out.println(hashSet);
        System.out.println(TSet);
        System.out.println(lhSet);
        
    }
}
