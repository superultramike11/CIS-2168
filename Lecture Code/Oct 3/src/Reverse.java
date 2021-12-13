public class Reverse {
   public static void main(String[] args) {
      Stack<Integer> stack = new Stack<Integer>();
      In in = new In("someInts.txt");    // input: 2 1 6 8

      // produce and initialize the elements into the stack
      while (!in.isEmpty())
         stack.push(in.readInt());

      // read the stack output: 8 6 1 2 (input reversed)
      for (int i : stack)
         System.out.print(i + " ");
   }
}
