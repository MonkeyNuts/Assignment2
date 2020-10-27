import java.util.ArrayList;
import java.util.List;
// just holds all the arraylists and objects that are used in logic and other classes
//has setup methods to add npcs and items to the list arrays
public class Objects {
	static Character player = new Character();
	static Combat combat = new Combat();
	static combatRNG rng = new combatRNG();
	static ArrayList<Room> room = new ArrayList<Room>();
	static List<NPC> NPCList = new ArrayList<NPC>();
	static List<Item> ItemList = new ArrayList<Item>();
	static List<NPC> npc = new ArrayList<NPC>();
	//^^^ could this be done different? like a collection?
	
	public static void setupNPCArray() {
		//TODO Add new NPC's here
		NPCList.add(new NPC());
		NPCList.add(new Guard());
		NPCList.add(new Prisoner());
		NPCList.add(new Giant_Rat());
		NPCList.add(new Archer());
		NPCList.add(new Ghost());
		NPCList.add(new Hound());
		NPCList.add(new Jagermeister());
		NPCList.add(new Elite_Guard());
		NPCList.add(new Evil_Wizard());
                NPCList.add(new Zombie());
	}
	
	public static void setupItemArray() {
		//TODO Add new items here
		ItemList.add(new Item());
		ItemList.add(new Rusty_Sword());
		ItemList.add(new Shank()); //(forgot to add this!)
		ItemList.add(new Excalibur());
                ItemList.add(new Sword());
                ItemList.add(new Cutlass());
                ItemList.add(new Dagger());
                ItemList.add(new Zweilander());
                ItemList.add(new Great_Sword());
	}
}
