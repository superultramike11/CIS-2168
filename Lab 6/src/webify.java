// Java Program to illustrate reading from Text File 
//
/*

    USE t.txt FILE TO TEST CODE

*/
import java.io.*; 
import java.util.*; 

public class webify { 
    public static boolean IS = false; 
    public static void main(String[] args) throws Exception {
        // asks the user for file they want to scan
        System.out.println("Input the full file name: ");
        Scanner fileScan = new Scanner(System.in);
    	String fileName = fileScan.next();
    	
    	// pass the path to the file as a parameter 
    	File file = new File(fileName); 
    	Scanner sc = new Scanner(file); 
    	
    	// The new formatted file will then output into a new html file
    	PrintStream out = new PrintStream(new File("d.html"));
        
        out.println("<html>");
    	out.println("<body>");
    
    	while (sc.hasNextLine()) {
    	    String line = sc.nextLine();
    	    String textOutline = textFormat(line, out);
    	    out.println(textOutline);
    	}
    	
    	out.println("</body>");
    	out.println("</html>");
    } 
    
    public static String textFormat(String line, PrintStream out) {
        String textOutline = "";
        
        if (line.startsWith("-") && IS == false) {
            IS = true;
            out.println("<ul>");
            line = "<li>" + line.substring(2, line.length()) + "</li>"; // do I change this?
        }
        else if(line.startsWith("-") && IS==true){
            line = "<li>" + line.substring(2, line.length()) + "</li>";
        }
        else if(IS == true){
            IS = false;
            out.print("</ul>\n<p>");
        }
        
        else if(line.startsWith("_") && line.endsWith("_")) {
            line = "<h1>" + line.substring(1, (line.length()-1)) + "</h1>";
        }
        
        else if (line.startsWith("[")) {
            String[] link = line.trim().split("]\\[");
    		String newlink0 = link[0].substring(2, link[0].length());
    		String newlink1 = link[1].substring(0, link[1].length()-2);
    		line = "<a href=\"" + newlink0 + "\">" + newlink1 + "</a>";
        }
        
        else if (line.isEmpty()){
            line = "<p>";
        }
        
        else {
            line = line + "</ br>";
        }
        
		return line;
    }
}