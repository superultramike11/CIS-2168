import java.util.NoSuchElementException;

public class Leader<E> {
   public int size;        // size of the list
   private Node first;    // reference to the first node of the list THE HEAD
   private Node last;    // reference to the last node of the list THE TAIL

   // Private helper Node data type
   private class Node {
      E data;
      Node next;

      // constructor: initializes data to the value e and
      // initializes the next Node reference to null
      Node(E e) { this(e, null); }

      // constructor: initializes data to the value e and
      // initializes the next Node reference to node
      Node(E e, Node node) {
         data = e; 
         next = node;
      }
   }

   // constructor: explicitly initializes an empty list 
   public Leader() { size = 0; first = last = null; }
 
   public static void main(String[] args) {
	   int n=9; // # of people in group
	   int m=5; // rate of picking person
	   Leader<Integer> list; 
	   list = new Leader<>();
	   
	   for(int i=1; i<=n; i++) {
	    	list.addLast(i);
	   } 
	   
	   System.out.println("Here is the people in the group: " + list);
	    
	   while(n != 1) {
		   for(int i=1; i<m; i++) { 
			   list.addLast(list.removeFirst());  
		   }
		   System.out.println("This number was removed: " + list.removeFirst()); 
		   n--;
	   }
	   System.out.println("This number is the winner! " + list);
	}
   
   // Inserts element as the last element of the list
   public void addLast(E value) { 
	   if(isEmpty()) first = last = new Node(value);
	   else last = last.next = new Node(value);
	   size++;
   }
    
   // Removes and returns the first element of the list
   public E removeFirst() {
	   if(isEmpty()) throw new NoSuchElementException("nothing in the list"); {}
	   E removed = first.data;
	   if(first == last)
		   first = last = null;
	   else
		   first = first.next; 
	   size--; 
	   return removed;
   }
   
   // Is this list empty? Returns true if it is and false if it is not
   public boolean isEmpty() {return size == 0;}
 
   // returns a string representation of this list
   public String toString() {
      StringBuilder s = new StringBuilder(); 
      if (isEmpty()) return "This list is empty";
      Node current = first;
      while(!(current == null)) {
    	  s.append( current.data + " "); 
    	  current = current.next;
      }
      //s.append("NULL"); 
      return s.toString();
   } 
}
