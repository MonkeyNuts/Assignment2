/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author proto
 */
public class Dagger extends Item{
        int accuracy = 9;
	int damage = 8;
	
	public Dagger() {
		id = "Dagger";
		name = "Dagger";
		description = "\nSomeone left a dagger here.";
		isEquipable = true;
		slot = "Weapon";
	}
}
