import java.util.ArrayList;
import java.util.List;
//defines a rooms and what can be in a room
public class Room {
	int number;
	String name;
	List<String> description = new ArrayList<String>();
	List<String> doors = new ArrayList<String>();
	ArrayList<NPC> npc = new ArrayList<NPC>(); 
	ArrayList<Item> item = new ArrayList<Item>();
	public Room(int x)
	{
		
		number = x;
		
	}
	

}
