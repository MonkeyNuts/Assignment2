//loops through the rooms, gets the number and sees what room your in, checks for npcs in that room
// and figures out what you want to attack based on the id entered
// returns random numbers based off accuracy to see if you or enemy is hit
// if enemy run out of hp they die and are removed from the room.
public class Combat {
	
	public void fight(String[] x) {
		if (x.length == 1) {
			System.out.println("What will you fight");
		}
		if (x.length == 2) {
			for (int i = 0; i < Objects.room.size(); i++) {
				if (Objects.room.get(i).number == Objects.player.inRoom) {
					for (int j = 0; j < Objects.room.get(i).npc.size(); j++) {
						if (Objects.room.get(i).npc.get(j).id.equalsIgnoreCase(x[1])) {
							int npcAttack = Objects.rng.random(100);
							npcAttack = npcAttack + (Objects.room.get(i).npc.get(j).accuracy / 2);
							if (npcAttack > 50) {
								int npcDamage = Objects.rng.random(10);
								Objects.player.hp = Objects.player.hp - npcDamage;
								System.out.println("The " +Objects.room.get(i).npc.get(j).name+ " attacks you for "+npcDamage+ " Damage.");
							} 
							else {
								System.out.println("The " +Objects.room.get(i).npc.get(j).name+ " misses you.");
							}
							int playerHit = Objects.rng.random(100);
							playerHit = playerHit + (Objects.room.get(i).npc.get(j).accuracy / 2);
							if (playerHit > 50) {
								int playerDamage = Objects.rng.random(10);
								Objects.room.get(i).npc.get(j).hp = Objects.room.get(i).npc.get(j).hp - playerDamage;
								System.out.println("You attack for " +playerDamage+ " Damage.");
								if (Objects.room.get(i).npc.get(j).hp <= 0) {
									npcKilled(i,j);
								}
							}
							else {
								System.out.println("You miss");
							}
						}
					}
				}
			}
		}
	}
	public void npcKilled(int i, int j) {
		System.out.println("A " +Objects.room.get(i).npc.get(j).name+ " has been slain.");
		Objects.room.get(i).npc.remove(j);
	}
}
