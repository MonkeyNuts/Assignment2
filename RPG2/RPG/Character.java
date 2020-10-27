import java.util.ArrayList;
//Character has a name, hp,accuracy inRoom (starts at 0 for character creation)
// and two arraylists for items and items the character is wearing.
// has look method to show characters hp and acc when you use look self
//has remove, equipment and equip methods
//remove removes item from a character by taking it out of wornItems array
//equipment simply shows a characters worn items
//equip adds an item to wornItems.
public class Character {
	String name;
	int hp;
	int accuracy;
	int inRoom = 0;
	ArrayList<Item> item = new ArrayList<Item>(); //maybe not static
	ArrayList<Item> wornItems = new ArrayList<Item>();
	public void look() {
		System.out.println("Hp:" +hp);
		System.out.println("Accuracy:" +accuracy);
	}
	public void remove(String[] x) {
		for (int i = 0; i < wornItems.size(); i++) {
			if (wornItems.get(i).id.equalsIgnoreCase(x[1])) {
				System.out.println("You remove a " +wornItems.get(i).id);
				item.add(wornItems.get(i));
				wornItems.remove(i);
			}
		}
	}
	public void equipment() {
		for (int i = 0; i < wornItems.size(); i++) {
			System.out.println(wornItems.get(i).slot+ ": " +wornItems.get(i).name);
		}
	}
	public void equip(String[] x) {
		if (wornItems.size() == 0) {
			for (int i =0; i < item.size(); i++ ) {
				if(x[1].equalsIgnoreCase(item.get(i).id) && item.get(i).isEquipable) {
					wornItems.add(item.get(i));
					System.out.println("You equip a "+item.get(i).name);
					item.remove(i);
					break;
				}
			}
		}
		else {
			boolean isWearing = false;
			for (int i = 0; i < wornItems.size(); i++) {
				for (int j = 0; j < item.size(); j++) {
					if(x[1].equalsIgnoreCase(item.get(j).id) && item.get(j).isEquipable) {
						if(item.get(j).slot.equals(wornItems.get(i).slot)) {
							System.out.println("You already have an item equiped in this slot");
							isWearing = true;
						}
					}
				}
				if(!isWearing) {
					wornItems.add(item.get(i));
					System.out.println("You equip a "+item.get(i).name);
					item.remove(i);
					break;
				}
			}
		}
		
	}
}
