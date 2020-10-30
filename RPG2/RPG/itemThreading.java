import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
//takes in an instance of logic, reads npclocations into an array list scanning
//through splitting by spaces, loops through all the rooms to see if the second index
//equals the room number to spawn the specified npc which is in the first index.
//(THIS ISNT WORKING IT ONLY READS THE FIRST LINE)
public class itemThreading extends NPC{
	Logic runningLogic;
	
	public itemThreading(Logic L) {
		runningLogic = L;
	}
	
	public void itemThread() {
		Thread one = new Thread() {
			public void run() {
				try {
					while(true) {
						itemSpawner();
						Thread.sleep(100000);
					}
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		};
		one.start();
	}
	
	public void itemSpawner() {
		//int npcCount = 0;
		List<String> lines = new ArrayList<String>();
		try {
			lines = runningLogic.readLines("Files/itemLocations.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < lines.size(); i++) {
			int itemCount = 0;

			String[] words = lines.get(i).split(" ");
			if (words[0].equals("Name:")) {
				for (int j = 0; j < Objects.room.size(); j++) {
					if (Objects.room.get(j).number == Integer.parseInt(words[2])) {
						for (int k = 0; k < Objects.room.get(j).item.size(); k++) {
							if (Objects.room.get(j).item.get(k).id.equalsIgnoreCase(words[1])) {
								itemCount++;
							}
						}
					}
				}
				if (itemCount == 0) {
					for (int y = 0; y < Objects.room.size(); y++) {
						if (Objects.room.get(y).number == Integer.parseInt(words[2])) {
									try {
										Objects.room.get(y).item.add((Item) Class.forName(words[1]).getConstructor().newInstance());

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
				itemCount++;
			}
		}
	}

