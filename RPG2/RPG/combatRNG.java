import java.util.Random;
//returns random number depending on the range passed in.
public class combatRNG {

	public int random(int x) {
		Random rng = new Random();
		int i = rng.nextInt(x);
		return i;
	}
}
