import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
// writes character details to a file, doesnt really do anything in the game.
//immersion? 
public class characterDetail {
	public static void Details() {
		String Details;
		 System.out.print("Write any other details you want about your character: ");
		 System.out.print("\n");
	        Scanner scan = new Scanner(System.in);
	        Details = JOptionPane.showInputDialog("Enter your details");
	        FileWriter fWriter = null;
	        BufferedWriter writer = null;
	        try {
	          fWriter = new FileWriter("Files/Details.txt");
	          writer = new BufferedWriter(fWriter);
	          writer.write(Details);
	          writer.close();
	          System.err.println("Your details were saved.");
	        } catch (Exception e) {
	            System.out.println("Error!");
	        }
	}
}
