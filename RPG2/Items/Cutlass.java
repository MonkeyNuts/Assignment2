/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author proto
 */
public class Cutlass extends Item{
        int accuracy = 10;
	int damage = 12;
	
	public Cutlass() {
		id = "Cutlass";
		name = "Cutlass";
		description = "\nA cutlass sits on a weapon rack.";
		isEquipable = true;
		slot = "Weapon";
	}    
}
