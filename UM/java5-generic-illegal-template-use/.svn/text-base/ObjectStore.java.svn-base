import java.util.*;

interface CombinedComparable<T> extends Comparable<String> { 
  int compareTo(T other); 
} 

public class ObjectStore<T extends CombinedComparable<T>> {   
  private void h(T t) { 
     AnUnrelatedClass.f(t);  
     AnotherUnrelatedClass.g(t); // error 
  } 
} 
