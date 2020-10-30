import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
//takes in an instance of logic, reads npclocations into an array list scanning
//through splitting by spaces, loops through all the rooms to see if the second index
//equals the room number to spawn the specified npc which is in the first index.
//(THIS ISNT WORKING IT ONLY READS THE FIRST LINE)
public class npcThreading extends NPC{
	Logic runningLogic;
	
	public npcThreading(Logic L) {
		runningLogic = L;
	}
	
	public void npcThread() {
		Thread one = new Thread() {
			public void run() {
				try {
					while(true) {
						npcSpawner();
						Thread.sleep(20000);
					}
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		};
		one.start();
	}
	
	public void npcSpawner() {
		//int npcCount = 0;
		List<String> lines = new ArrayList<String>();
		try {
			lines = runningLogic.readLines("Files/npcLocations.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < lines.size(); i++) {
			int npcCount = 0;

			String[] words = lines.get(i).split(" ");
			if (words[0].equals("Name:")) {
				for (int j = 0; j < Objects.room.size(); j++) {
					if (Objects.room.get(j).number == Integer.parseInt(words[2])) {
						for (int k = 0; k < Objects.room.get(j).npc.size(); k++) {
							if (Objects.room.get(j).npc.get(k).id.equalsIgnoreCase(words[1])) {
								npcCount++;
							}
						}
					}
				}
				// Objects.room.get(y).npc.add((NPC) Class.forName(words[1]).getConstructor().newInstance());  this is causing problems
				if (npcCount == 0) {
					for (int y = 0; y < Objects.room.size(); y++) {
						if (Objects.room.get(y).number == Integer.parseInt(words[2])) {
							 
							//NPC newNPC = (NPC) words[1];
							//Objects.room.get(y).npc.add((NPC) words[1]);
									try {
										Objects.room.get(y).npc.add((NPC) Class.forName(words[1]).getConstructor().newInstance());

									} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
											| InvocationTargetException | NoSuchMethodException | SecurityException
											| ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
							}
						}
					}
				}
				npcCount++;
			}
		}
	}
