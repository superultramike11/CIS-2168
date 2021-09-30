public class SLListTest<E> {
   public static void main(String[] args) {
      SLList<Integer> list;
    
      
      // TEST 1: addFirst, addLast, removeFirst, removeLast
      list = new SLList<>();
      System.out.println("--- Testing addFirst(), addLast(), removeFirst(), removeLast() ---");
      list.addFirst(8); list.addFirst(6); System.out.println(list); // 6 8
      list.removeLast(); list.removeFirst();
      System.out.println(list); // empty
      list.addLast(2); list.addLast(1); System.out.println(list); // 2 1
      list.removeLast(); System.out.println(list); // 2
      list.removeFirst(); System.out.println(list); // empty
      //list.removeLast(); //throws exception and exits
	  
       
      // TEST 2: add, indexOf
      
      list = new SLList<>(); System.out.println("\n\t --- Testing add(), indexOf() ---");
      list.add(0, 1);
      list.add(1, 6) ;
      System.out.println(list);  // 1 6
      list.add(99, 9);  //returns false, cannot add this value
      list.add(0, 2); list.add(3,8);
      System.out.println(list); // 2 1 6 8
      list.add(2,2168); System.out.println(list); // 2 1 2168 6 8
      System.out.println(list.add(4, 99) + " " + list.add(0, 77)); // true true
      System.out.println(list.add(-1,99)); // false
      System.out.println(list); // 77 2 1 2168 6 99 8

      System.out.println(list.indexOf(8) + " " + list.indexOf(2) + " " + list.indexOf(9)); // 6 1 -1
	  

       
      // TEST 3: remove
      System.out.println("\n\t ---Testing remove() ---");
      System.out.println("Starting with this list: " + list); // 77 2 1 2168 6 99 8
      System.out.print("Removing item at index 0: ");
      list.remove(0); System.out.println(list); // 2 1 2168 6 99 8
      System.out.print("Removing item at index 2: "); // 2 6 99 8
      list.remove(2); System.out.println(list);
      System.out.println("Trying to remove items at indexes -1, 99: ");
      System.out.println("\t remove(-1) returns " + list.remove(-1)); // false
      System.out.println("\t remove(99) returns " + list.remove(99)); // false 
      System.out.println("The list now is: " + list);
      System.out.print("Removing item at index 3: "); 
      list.remove(3); System.out.println(list); // 2 1 6 8 
      
 
       
      // TEST 4: get, set 
      System.out.println("\n\t ---Testing get(), set() ---");
      System.out.print(list.get(1) + " " + list.get(2) +  "\n"); // 1 6
      System.out.println(list.get(4)); // null
      //System.out.print(list.get(4) + " " + list.get(99) + " " + list.get(-1) + "\n"); // null null null
      list.set(-1, 9); list.set(4, 99); list.set(20, 21);
      System.out.println(list); // 2 1 6 8
      list.set(0, 8); list.set(2, 1); list.set(3,2); list.set(1,6);
      System.out.println(list); // 8 6 1 2
      

      
      // TEST 5: contains
      System.out.println("\n\t ---Testing contains() ---");
      System.out.println(list.contains(-1) + " " + list.contains(2) + " " + list.contains(99) + " " + list.contains(8));
                       // previous line prints: false true false true
      System.out.println(list.contains(6) + " " + list.contains(5) + " " + list.contains(1) + " " + list.contains(7));
                      // previous line prints: true false true false
   }
}
