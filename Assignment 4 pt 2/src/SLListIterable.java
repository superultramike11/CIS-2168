import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLListIterable<E> implements Iterable<E>{
   private int n;        // size of the list
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
   
   private Node getNode(int index) {
	   Node current = first;
	   for(int i=0; i<index && current != null; i++) 
		   current = current.next;
	   return current;
   }
   
   private void addAfter(Node node, E value) {
	   node.next = new Node(value, node.next);
	   n++;
   }

   // constructor: explicitly initializes an empty list
   public SLListIterable() { n = 0; first = last = null; }

   // Inserts element as the first element of the list
   public void addFirst(E element) { 
	   if(isEmpty()) {
		   first = last = new Node(element);
	   }
	   else {
		   first = new Node(element, first);
	   }
	   n++;
   }

   // Inserts element as the last element of the list
   public void addLast(E value) { 
	   if(isEmpty()) first = last = new Node(value);
	   else last = last.next = new Node(value);
	   n++;
   }
    
   // Removes and returns the first element of the list
   public E removeFirst() {
	   if(isEmpty()) throw new NoSuchElementException("nothing in the list"); {}
	   E removed = first.data;
	   if(first == last)
		   first = last = null;
	   else
		   first = first.next; 
	   n--; 
	   return removed;
   }
 
   // Removes and returns the last element of the list
   public E removeLast() {
	   if(isEmpty()) throw new NoSuchElementException("nothing in the list"); {}
	   E removed = last.data;
	   
	   if(first == last) first = last = null;
	   Node current = first; 
	   while(current.next != last) {
		   current = current.next;
	   }
	   last = current;
	   current.next = null; 
	   n--;
	   return removed;
   }  
    
   // Inserts element at position index, returns true if it succeeds and false if index is out of bounds
   public boolean add (int index, E element) {
	   if (index < 0 || index > n) {
		   System.out.println("Index out of bounds. Cannot add this value");
		   return false;
	   }
	   if (index == 0) { addFirst(element); return true;}
	   if (index == n) { addLast(element); return true;}
	   else { // anywhere in the middle
		   Node node = getNode(index-1);
		   addAfter(node, element);
		   return true;
	   }
   }
   
   // Is this list empty? Returns true if it is and false if it isn�t
   public boolean isEmpty() {return n == 0;}
   
   // removes the element at position index, returns true if it succeeds and false if index is out of bounds
   public boolean remove(int index) {
	    if (index<0 || index >=size()) {
	    	 
	        return false;
	    } 
	    Node current = first; 
	    for (int i = 0; i < index-1; i++) { 
	    	current = current.next;
	    }
	    if (index == 0) {
	        first = current.next;
	    } else {
	    	current.next = current.next.next; 
	    }
	    n--; 
	    return true;
   }
     
   // does the list contain element?
   public boolean contains(E element) {
	   	Node current = first;
	    while(current != null){
	        if(element.equals(current.data)) {
	            return true;
	        }
	        current = current.next;
	    }
	    return false;
   }
   
   // Returns the element at index without removing it
   public E get(int index) { 
	   if(index < 0 || index >= n) {
		   System.out.println("Index out of bounds. Returning null.");
		   return null; 
	   }
	   Node node = getNode(index);
	   return node.data;
   }

   // Sets the value of the element at index to element without removing it
   public E set(int index, E element) {
	   if(index < 0 || index >= n) {
		   System.out.println("Index out of bounds. Cannot set this value");
		   return null;
	   }
	   
	   Node node = getNode(index);
	   E oldValue = node.data;
	   node.data = element;
	   return oldValue;
   }
   
   // returns the index of the first occurrence of the value e in this list
   // returns -1 if e is not in the list
   public int indexOf(E element) {
	   int index = 0;
	   Node current = first;
	   while(current != null) {
		   if(current.data == element) {
			   return index; 
		   } 
		   current = current.next;
		   index++;  
	   }
	   return -1;  
   }
   
   public Iterator<E> iterator() {
	   return new LinkedIterator();
   }
   
   private class LinkedIterator implements Iterator<E> {
	   private Node current = first;
	   public boolean hasNext() { return current != null; }
	   public void remove() { throw new UnsupportedOperationException(); }
	   public E next() {
		   if(!hasNext()) throw new NoSuchElementException(); 
		   E value = current.data;
		   current = current.next;
		   return value;
	   }
   }

   // Returns the number of items in the list 
   public int size() { return n; }

   // returns a string representation of this list
   public String toString() {
      StringBuilder s = new StringBuilder();
      if (isEmpty()) return "This list is empty";
      Node current = first;
      while(!(current == null)) {
    	  s.append( current.data + " -> "); 
    	  current = current.next;
      }
      s.append("NULL"); 
      return s.toString();
   } 
      
   public static void main(String[] args) {
	   System.out.println("ghay");
   }
}
