/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author proto
 */
public class Great_Sword extends Item{
    	int accuracy = 7;
	int damage = 15;
	
	public Great_Sword() {
		id = "Great_Sword";
		name = "Great Sword";
		description = "\nA great sword stands on display from a famous warrior.";
		isEquipable = true;
		slot = "Weapon";
	}
}
