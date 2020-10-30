
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

//TODO Error list: null pointer exception with summon x and create x (summon fixed, inRoom wasnt in NPC class)
// file reader not outputting properly (easy to fix, mostly done already)
// move command not working (no error just nothing happens) (FIXED: file reader errors, fixed door
// output in general not working properly need to fix nesting?


//changed ++x incrementation to x++.

//TODO expansion: add title screen
//MUST TODO: add file input (in character creation probably (race,gender,looks)).

//Stuck TODO cant get the npcThreading to work. only spawns npc from first line of file.
public class Logic {
	public Logic() {
		Objects.room.add(new Room(0));
	
		List<String> roomDetails = new ArrayList<>();
		
		try {
			roomDetails = readLines("Files/RoomDescriptions.txt");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < roomDetails.size(); i++) { //needs to be i++
			
			String[] wordOne = roomDetails.get(i).split(" ");
			String[] afterOne = roomDetails.get(i).split(":");
			
			if (wordOne[0].equals("RoomName:")) {
				int thisRoomSize = Objects.room.size();
				Objects.room.add(new Room(thisRoomSize));
				Objects.room.get(Objects.room.size() -1).name = afterOne[1];
				Objects.room.get(Objects.room.size() -1).number = (thisRoomSize);
				
				int roomCount = 0;
				for (int j = 0; j < roomDetails.size(); j++) {
					String[] nextWordOne = roomDetails.get(j).split(" ");
					if (nextWordOne[0].equals("RoomName:")) {
						++roomCount;
					}
					if (roomCount == thisRoomSize) {
						if (nextWordOne[0].equals("Description:")); {
						String[] nextAfterOne = roomDetails.get(j).split(": ");
						Objects.room.get(Objects.room.size() -1).description.add(nextAfterOne[1]);
						}
					}
				}
				roomCount = 0;
				for (int k = 0; k < roomDetails.size(); k++){
					String[] nextWordOne = roomDetails.get(k).split(" ");
					if (nextWordOne[0].equals("RoomName:")) {
						++roomCount;
					}
					if (roomCount == thisRoomSize) {
						if (nextWordOne[0].equals("Doors" + ":")) {
							String[] nextAfterOne = roomDetails.get(k).split(":");
							Objects.room.get(Objects.room.size() -1).doors.add(nextAfterOne[1]);
						}
					}
				}
			}
		}
	}
	public List<String> readLines(String filename) throws IOException{
		FileReader fileRead = new FileReader(filename);
		BufferedReader bufferedRead = new BufferedReader(fileRead);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedRead.readLine())!= null) {
			lines.add(line);
		}
		bufferedRead.close();
		return lines;
	}
	// loops through all the rooms and checks if the room number is the same as the one youre in
	// and also get the doors and loop through those which are put into a string
	// checks to see if the user typed in a matching door, then increment to place
	// the player into the room corresponding to the door
	public void move(String[] x) {
		if (x.length == 1) {
			System.out.println("Where will you move?");
		}
		if (x.length == 2) {
			
			for (int i = 0; i < Objects.room.size(); i++) {
				if (Objects.room.get(i).number == Objects.player.inRoom) {
					for (int j = 0; j < Objects.room.get(i).doors.size(); j++) {
						
						String doorExit = Objects.room.get(i).doors.get(j);
						String[] doorArray = (doorExit.split(" "));
						if (x[1].equalsIgnoreCase(doorArray[1])) {
							Objects.player.inRoom = Integer.parseInt(doorArray[2]);
                                                        RPGMainJFram.updateRoom();
							System.out.println("You exit " +doorArray[1]);
                                                      
						}
					}
				}
			}
		}
	}
	// With input command, the player starts in room 0 (which is not a room in the game)
	// which triggers the characterCreator method.
	// input command is run every game loop and is used to contro everything in the game
	public void inputCommand() {
		if (Objects.player.inRoom == 0) {
			characterCreator();
		}
		System.out.println("\n");
		System.out.println("What will you do?");
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine();
		String[] words = command.split(" ");
		processCommand(words);

	}
//if x = a specific command it will run that command method
	public void processCommand(String[] x) {
		if(x[0].equalsIgnoreCase("look")) {
			look(x);
		}
		if(x[0].equalsIgnoreCase("spawn")) {
			spawn(x);
		}
		if(x[0].equalsIgnoreCase("create")) {
			create_item(x);
		}
		if(x[0].equalsIgnoreCase("equip")) {
			Objects.player.equip(x);
		}
		if(x[0].equalsIgnoreCase("equipment")) {
			Objects.player.equipment();
		}
		if(x[0].equalsIgnoreCase("remove")) {
			Objects.player.remove(x);
		}
		if(x[0].equalsIgnoreCase("move")) {
			move(x);
		}
		if(x[0].equalsIgnoreCase("fight")) {
			Objects.combat.fight(x); 
		}
		if(x[0].equalsIgnoreCase("get")) {
			get(x); 
		}
	}
	// if input matches item in the itemlist it will create a new instance
	//called roomItem and put the item in the room youre in
	public void create_item(String[] x) {
		if (x.length == 1) {
			System.out.println("What will you create?");
		}
		if (x.length == 2) {
			for (int i = 0; i < Objects.ItemList.size(); i++) {
				Item roomItem = Objects.ItemList.get(i);
				if (roomItem.id.equalsIgnoreCase(x[1])) {
					for (int j = 0; j < Objects.room.size(); j++) {
						if (Objects.room.get(j).number == Objects.player.inRoom) {
								Objects.room.get(j).item.add(roomItem);
								System.out.println("You create a " +Objects.room.get(j).item
								.get(Objects.room.get(j).item.size() - 1).name);
						}
					}
				}
			}
		}
	}
	//if input matches the item in the room it removes the item from the room and 
	//your character gets it.
	public void get(String[] x) {
		if (x.length == 1) {
			System.out.println("What will you get?");
		}
		if (x.length == 2) {
			for (int i = 0; i < Objects.ItemList.size(); i++) {
				for (int j = 0; j < Objects.room.size(); j++) { // changed to i++ fixed issue 
					if (Objects.room.get(j).number == Objects.player.inRoom) {
						for (int k = 0; k < Objects.room.get(j).item.size();){
							if (x[1].equalsIgnoreCase(Objects.room.get(j).item.get(k).id));{
								Item roomItem = Objects.room.get(j).item.get(k);
								Objects.player.item.add(roomItem);
								System.out.println("You pick up a " +roomItem.name);
								Objects.room.get(j).item.remove(k);
								RPGMainJFram.updateInventory();
								break;
							}
						}
					}
				}
			}
		}
			
	}
	//use look (look self, look npc) to look at the room your in, its details and whats in it
	// look self shows your own stats and look prisoner with show a prisoners stats.
	public void look(String[] x) {
		if (x.length == 1) {
			System.out.println("\n");
			for (int i = 0; i < Objects.room.size(); i++) {
				if (Objects.room.get(i).number == Objects.player.inRoom) {
					for (int j = 0; j < Objects.room.get(i).description.size(); j++) {
						System.out.println(Objects.room.get(i).description.get(j).replaceAll("[0-9]",""));
						if(j == 5) {
							System.out.println("\n");
							System.out.println("Doors:");
						}
					}
					for(int j = 0; j < Objects.room.get(i).doors.size(); j++) {
						String doorFullName = Objects.room.get(i).doors.get(j);
						String[] doorName = doorFullName.trim().split(" ");
					}
				
					for (int k = 0; k <Objects.room.get(i).npc.size(); k++) {
						System.out.println(Objects.room.get(i).npc.get(k).description);
					}
					for (int y = 0; y <Objects.room.get(i).item.size(); y++) {
						System.out.println(Objects.room.get(i).item.get(y).description);
					}
				}
			}
		}
		if (x.length == 2) {
			if(x[1].equals("self")) {
				Objects.player.look();
				System.out.println("You are carrying:");
				for (int i = 0; i < Objects.player.item.size(); i++) {
					System.out.println(Objects.player.item.get(i).name);
				}
			}
			//looks at an npc the user has entered and displays its stats.
			for (int j = 0; j < Objects.room.size(); j++) {
				if (Objects.room.get(j).number == Objects.player.inRoom) {
					for (int k = 0; k < Objects.room.get(j).npc.size(); k++) {
						if(x[1].equalsIgnoreCase(Objects.room.get(j).npc.get(k).id)) {
							Objects.room.get(j).npc.get(k).look();
						}
					}
				}
			}
		}
	}
	//checks to see if input matches npc from npc list, it will create a new instance
	//called roomNPC and put the NPC in the room youre in
	public void spawn(String[] x) {
		if (x.length == 1) {
			System.out.println("What will you spawn?");
		}
		if (x.length == 2) {
			for (int i = 0; i < Objects.NPCList.size(); i++) {
				NPC roomNPC = Objects.NPCList.get(i);
				if (roomNPC.id.equalsIgnoreCase(x[1])) {
					System.out.println(roomNPC.id);
					for (int j = 0; j < Objects.room.size(); j++) {
						if (Objects.room.get(j).number == Objects.player.inRoom) {
								Objects.room.get(j).npc.add(roomNPC);
								System.out.println("You spawn a " +Objects.room.get(j).npc
										.get(Objects.room.get(j).npc.size() - 1).name);
					}
				}
			}
		}
	}
}
	
	// input for the players name, has a bit of story elements, stats given are always the same.
	public void characterCreator() {
		//Title.titleScreen();
		System.out.println("");
		System.out.println("\"Greetings... What is your name traveller?\"");
		Scanner scan = new Scanner(System.in);
		Objects.player.name = JOptionPane.showInputDialog("Enter your name");
                RPGMainJFram.jLabelName.setText(RPGMainJFram.jLabelName.getText() + Objects.player.name);
		characterDetail.Details();
		System.out.println("\n");
		System.out.println("\"You look weak " +Objects.player.name+ "\"" + " The shady old man performs some magic healing spell on you. \nYou feel nauseous but energised." );
		Objects.player.hp = 100;
		Objects.player.accuracy = 75;
                RPGMainJFram.jLabelHPNum.setText(String.valueOf(Objects.player.hp));
                RPGMainJFram.jLabelAccNum.setText(String.valueOf(Objects.player.accuracy));
		System.out.println("Your stats have been updated.");
		System.out.println("Hp: 100 \nAccuracy: 75");
		Objects.player.inRoom = 1;
                RPGMainJFram.updateRoom();
                
	}
}
