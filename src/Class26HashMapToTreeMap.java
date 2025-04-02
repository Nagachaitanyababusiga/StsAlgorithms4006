import  java.util.*;
import java.util.stream.Collectors;

/*
    Hash Map:- 
    Key value (Hash table)
    Constant time O(1) (Average)
    Random Order 

    Tree Map:-
    Red Black Tree (root is always black)
    log(n) retreval
    Sorted order
    All the values will be sorted automatically

    Methods:
    1. Using collectors
    2. Vanilla java method
    3. Guava method
    4. Manual method

*/

public class Class26HashMapToTreeMap {
    //vanilla java
    public static <K,V> Map<K,V> convertToTreeMapUsingVanilla(Map<K,V> hashMap){
        Map<K,V> treeMap=new TreeMap<>();
        treeMap.putAll(hashMap);
        return treeMap;
    }
    //collectors
    public static <K,V> Map<K,V> convertToTreeMapUsingCollectors(Map<K,V> hashMap){
        Map<K,V> treeMap=hashMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)->newValue,TreeMap::new));
        return treeMap;
    }
    //Using guava library
    /*
    public static <K,V> Map<K,V> convertToTreeMapUsingGuavaLibrary(Map<K,V> hashMap){
        
    }
    public static <K extends Comparable<?super K>,V> Map<K,V> convertToTreeMap(Map<K,V> hashMap){
        
    }
    */
    public static void main(String[] args) {
        
    }
}
