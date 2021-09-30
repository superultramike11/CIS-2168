public class CircularQueue<E> {
   private int n;        // size of the list
   private Node last;   // reference to the first node of the list
   private Node first;

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

   // constructor: initializes an empty list
   public CircularQueue() { n = 0; } // fist = last = null by default

   
   // adds an element to the front of the list
   public void addFirst(E value) {
	   first = new Node(value, first); // The Node constructor does all the work
	   n++; // increment list size
   }
 
   // adds element to the end of the list
   public void enqueue(E value) {
	   if (isEmpty()) {
		   addFirst(value);
	   }
	   else {
		   Node current = first;
		   while (current.next != null) {
			   current = current.next;
		   }
		   Node last = new Node(value); 
		   current.next = last;
		   n++;
	   } 
   }
 
   // removes and returns the first element from the list
   public E dequeue() {
	   if(isEmpty()) {
           return null; 
       }
	   else {
		   Node current = first;
		   first = first.next;
		   n--;
		   return current.data; 
	   } 
   }

   // is this list empty?
   public boolean isEmpty() {
	   return n == 0; 
   }

   // the size of this list (the number of nodes in it)
   public int size() {
	   return n;
   }

   // returns a string representation of this list
   public String toString() {
      StringBuilder s = new StringBuilder();
      if (isEmpty()) return "This list is empty ";
      Node current = first;
      while (current != null) {
         s.append(current.data + " ");
         current = current.next;
      }
      return s.toString();
   }
   
   public static void main(String[] args) { 
	   CircularQueue<String> list;
	   
	   // TEST 1: testing enqueue()
	   list = new CircularQueue<>();
	   System.out.println("\nCreated an empty list: [ " + list +"]" + "  // size = " + list.size());
	   System.out.println("\tTesting enqueue: ");
	   list.enqueue("to");
	   System.out.println("After adding an item at the end: [ " + list +"]" + "  // size = " + list.size());
	   list.enqueue("be");
	   System.out.println("After adding another item at the end: [ " + list +"]" + "  // size = " + list.size());
	   list.enqueue("or"); list.enqueue("not"); list.enqueue("to"); list.enqueue("be");
	   System.out.println("After adding 4 more items at the end: [ " + list +"]" + "  // size = " + list.size());
	   
	   // TEST 2: testing dequeue()
	   list = new CircularQueue<>();
	   list.addFirst("vibes"); list.addFirst("good");
	   System.out.println("\nThe new list is: [ " + list +"]" + "  // size = " + list.size());
	   System.out.println("\tTesting dequeue: ");
	   list.dequeue();
	   System.out.println("After removing 1st: [ " + list +"]" + "  // size = " + list.size());
	   list.dequeue(); list.dequeue();
	   System.out.println("After removing two more: [ " + list +"]" + "  // size = " + list.size());
   }
}
