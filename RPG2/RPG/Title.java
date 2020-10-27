import java.util.Scanner;
//title screen for the game, shows commands to use
public class Title {
	
public static void titleScreen() {
	System.out.println("                            SLAY THE EVIL WIZARD                     ");
	
	System.out.println("                      | |__|__|__|__|__|__|__|__|__|_|                       ");
	System.out.println(" __    __    __       |_|___|___|___|___|___|___|___||       __    __    __  ");
	System.out.println("|__|  |__|  |__|      |___|___|___|___|___|___|___|__|      |__|  |__|  |__| ");
	System.out.println("|__|__|__|__|__|       \\____________________________/       |__|__|__|__|__| ");
	System.out.println("|_|___|___|___||        |_|___|___|___|___|___|___||        |_|___|___|___|| ");
	System.out.println("|___|___|___|__|        |___|___|___|___|___|___|__|        |___|___|___|__| ");
	System.out.println(" \\_|__|__|___|/          \\________________________/          \\_|__|__|__|_/  ");
	System.out.println("  \\__|____|__/            |___|___|___|___|___|__|            \\__|__|__|_/   ");
	System.out.println("   |||_|_|_||             |_|___|___|___|___|__|_|             |_|_|_|_||    ");
	System.out.println("   ||_|_|||_|__    __    _| _  __ |_ __  _ __  _ |_    __    __||_|_|_|_|    ");
	System.out.println("   |_|_|_|_||__|__|__|__|__|__|__|__|__|__|__|__|__|__|__|__|__|_|_|_|_||    ");
	System.out.println("   ||_|||_|||___|___|___|___|___|___|___|___|___|___|___|________________    ");
	System.out.println("   |_|_|_|_||_|___|___|___|___|___|___|___|___|___|___|_|Commands:              ");
	System.out.println("   ||_|_|_|_|___|___|___|___|___|___|___|___|___|___|___|look (look, npc id, self)");
	System.out.println("   ||_|_|_|_|___|___|___|___|___|_/| | | \\__|___|___|___|move (north, south etc)");
	System.out.println("   |_|_|_|_||_|___|___|___|___|__/ | | | |\\___|___|___|_|get (item)            ");
	System.out.println("   ||_|_|_|||___|___|___|___|___|| | | | | |____|___|___|equip (item)           ");
	System.out.println("   |_|_|_|_||_|___|___|___|___|_|| | | | | |__|___|___|_|equipment (items)      ");
	System.out.println("  /___|___|__\\__|___|___|___|___|| | | | | |____|___|___|remove (item)         ");
	System.out.println(" |_|_|_|_|_|_||___|___|___|___|_|| | | | | |__|___|___|_|fight (npc id)         ");
	System.out.println(" ||_|_|_|_|_|_|_|___|___|___|___||_|_|_|_|_|____|___|___|README for dev commands");
	System.out.println("\n");
	System.out.println("                           Press any key to start.                   ");
	Scanner scan = new Scanner(System.in);
	String started = scan.nextLine();
	}
}
