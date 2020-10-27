
public class Sword extends Item{
    	int accuracy = 10;
	int damage = 10;
	
	public Sword() {
		id = "Sword";
		name = "Sword";
		description = "\nA sword is hidden away in the corner.";
		isEquipable = true;
		slot = "Weapon";
	}
}
