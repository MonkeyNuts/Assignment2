
public class Game {
// creates instance of logic class called gameLogic, initialises array
// starts the npcthreading and starts the game looper
// gameLogic.inputCommand(); is just going to repeat waiting for a command
	static Logic gameLogic = new Logic();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Objects.setupNPCArray();
		Objects.setupItemArray();
                itemThreading threads = new itemThreading(gameLogic);
                threads.itemThread();
		npcThreading thread = new npcThreading(gameLogic);
		thread.npcThread();
		while(true)
		{
		gameLooper();
		}

	}
	
	public static void gameLooper()
	{
		gameLogic.inputCommand();
	}

}
