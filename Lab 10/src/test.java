import java.util.*;
import java.io.*;

public class test {

	public static void main(String[] args) 
	{
	    ArrayList<String> list = new ArrayList<String>();
	    list.add("This");
	    list.add("is");
	    list.add("a");
	    list.add("test");
	    for (int i=0; i<list.size(); i++)
	    {
	        if(list.get(i).length()!=2)
	        {
	            list.remove(i); 
	            i--; 
	        }
	    }
	    for(String word: list) {
	    	System.out.println(word);
	    }
	}

}
