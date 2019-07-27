import java.util.*;

public class Game {
	
	
	//Player Attributes
	int pHP;
	int pAtk;
	int maxPAtk = 200;
	String pWeapon;	
	String pName;
	
	int resetHP = 100;
	
	//Enemy Attributes
	String enemy;
	int eAtk;
	int maxEAtk = 125;
	int eHP;
	int maxEHP = 150;
	String eWeapon;
	
	int numHealthPotions = 0;
	int healthPotionHealAmount = 30;
	int healthPotionDropChance = 50; //percentage
	int healthPotionFindChance = 10; //percentage
	
	String specialItem;
	int blacksmithKey = 0;
	int blacksmithSword = 1;
	int blacksmithKnife = 0;
	
	//System Objects
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	
	public static void main(String[] args) {
		
		 Game game;
		 game = new Game();
		 
		 game.playerSetUp();
		 
		 game.forest();		 
		 

	
	}
	
	public void forest() {
		
		 System.out.println("    ______                     __ \r\n" + 
		 		"   / ____/___  ________  _____/ /_\r\n" + 
		 		"  / /_  / __ \\/ ___/ _ \\/ ___/ __/\r\n" + 
		 		" / __/ / /_/ / /  /  __(__  ) /_  \r\n" + 
		 		"/_/    \\____/_/   \\___/____/\\__/  \r\n" + 
		 		"                                  ");
		
		sitrep();
				
		System.out.println("\tYou look around and realise you're in a forest");
		System.out.println("\tIt's pretty, and there doesn't appear to be any immediate danger");
		System.out.println("\tThere's a path just ahead, and a fresh mound of dirt close by");
		System.out.println("");
		findRandomItem();
		System.out.println("\tWhat do you want to do?");
		System.out.println("\t> 1. Investigate Fresh Mound of Dirt"); //gives Knife
		System.out.println("\t> 2. Follow the Path"); //to townGate
		
		String fChoice;
		fChoice = input.nextLine();
		
		if (fChoice.equals ("1")) {

			System.out.println("");
			System.out.println("\tYou dig up the mound with your bare hands");
			System.out.println("\t# You found a knife #");
			
			
			pWeapon = "Knife(30)";
			
			sitrep();
			
			System.out.println("");
			System.out.println("\tNow you have a knfe, let's follow the path...");
				townGate();
		}
			
			else if (fChoice.contentEquals("2")) {
				System.out.println("");
				System.out.println("\tYou follow the path, and after walking for a while, you see buildings in the distance");
				System.out.println("\tYou head for the buildings...");
				townGate();
			}
			
		
			
		}
	
	public void townGate() {
		
		System.out.println(" ______                       ______      __     \r\n" + 
				" /_  __/___ _      ______     / ____/___ _/ /____ \r\n" + 
				"  / / / __ \\ | /| / / __ \\   / / __/ __ `/ __/ _ \\\r\n" + 
				" / / / /_/ / |/ |/ / / / /  / /_/ / /_/ / /_/  __/\r\n" + 
				"/_/  \\____/|__/|__/_/ /_/   \\____/\\__,_/\\__/\\___/ \r\n" + 
				"                                                  ");
		
		
		
		enemy = ("Gaurd");
		eAtk = rand.nextInt(maxEAtk);
		eHP = rand.nextInt(maxEHP);
		eWeapon = ("Sword");
		
		sitrep();
		
		System.out.println("");
		System.out.println("\tYou are at the gate of a medievil town.");
		System.out.println("\tA gaurd is standing in front of you.");
		System.out.println("\tA Sign reads 'No Vac_____' - some of the letters are missing.");
		System.out.println("\tYou see a flag showing a bat, blowing in the wind.");
		System.out.println("");
		System.out.println("   /\\                 /\\\r\n" + 
				"  / \\'._   (\\_/)   _.'/ \\\r\n" + 
				" /_.''._'--('.')--'_.''._\\\r\n" + 
				" | \\_ / `;=/ \" \\=;` \\ _/ |\r\n" + 
				"  \\/ `\\__|`\\___/`|__/`  \\/\r\n" + 
				"   `      \\(/|\\)/       `\r\n" + 
				"           \" ` \"");
		findRandomItem();
		guardChoice();
		
				} //end townGate method						
		
	public void blacksmithDecision() {	
			
		
		System.out.println("You're standing outside a stone building, it seems deserted.");
		System.out.println("There's an anvil outside, with a shiny new sword next to it");
		System.out.println("Decision making time, what will you do next " + pName + "?");
		System.out.println("> 1. Try the door");
		System.out.println("> 2. Swap your " + pWeapon + " for the Sword");
		System.out.println("> 3. Go back to the Sign");
		
		String blackChoice;
		
		blackChoice = input.nextLine();
		
		if (blackChoice.equals("1")) {
			
			blacksmithKeyInv();
			
		}
		
		else if (blackChoice.equals("2")) {
			
			if (blacksmithSword > 0) {
				
				blacksmithSword--;
				blacksmithKnife++;
				pWeapon = "Sword(43)";
				pAtk = 43 + (pHP / 2);
				
				System.out.println("\tYou dropped your knife, and took the Sword!");
				System.out.println("\t# Your attack is now " + pAtk + "! #");
				blacksmith();
				
			}
			
			else {
				System.out.println("\tThere's no Sword here... I think that hangover is affecting your memory!");
				System.out.println("");
			}
		}
		
		else if (blackChoice.equals("3")) {
			
			townNovac();
		}
		
		else {
			
			System.out.println("\tInvalid Command, try again");
			blacksmith();
		}
		
		}
	
	public void blacksmithInterior() {
		
		System.out.println("\tYou tiptoe into the Blacksmith's workshop, and have a look around.");
		System.out.println("\tYou allow your eyes to adjust for a moment, and notice just how silent eveything is.");
		System.out.println("\tAs your eyes adjust, you notice something on the floor...");
		System.out.println("\tLooks like a body, a fat man, with a sash that reads:");
		System.out.println("Insert MAYOR HEAD ASCII here");
		System.out.println("\tI guess this is Mayor Dong - and what's that scratched in the wood floor?");
		System.out.println("\tA single word...or rather, a name... ELIZABETH");
		System.out.println("\tNo idea who Elizabeth is, but you'd better remember that...he scratch it with his nails before he died!");
		System.out.println("\tNothing else to see here, better go back outside");
		
		blacksmith();
		
	}
	
	public void blacksmithKeyInv() {
		
		if (specialItem == "blacksmithKey") {
			
			blacksmithInterior();
			
		}
		
		else {
			
			System.out.println("\tYou rattle the door, it's locked, and no one seems to be home");
			blacksmith();
		}
		
	}

	public void drinkPotion() {
		
		numHealthPotions--;
		pHP = pHP + healthPotionHealAmount;
		
		System.out.println("\t\tGlug Glug Glug... health increased by " + healthPotionHealAmount + " HP.");
		System.out.println("\t\tYou have " + numHealthPotions + " remaining.");
		
		}
	
	public void guardChoice() {
		
		System.out.println("");
		System.out.println("\tWhat do you want to do?");
		System.out.println("\t> 1. Talk to the Gaurd");
		System.out.println("\t> 2. Attack the Gaurd");
		System.out.println("\t> 3. Leave");
		
		String townGateChoice;
		townGateChoice = input.nextLine();
		
		if (townGateChoice.equals ("1")) {

			System.out.println("");
			System.out.println("\t" + pName + ": Excuse me...");
			System.out.println("\tGaurd: You should not be here...Turn back, or die!");
			System.out.println("\t" + pName + ": What happened here?");
			System.out.println("\tGuard: Leave now or die by my sword!");
			
			guardChoice();	
			
		}
			
			else if (townGateChoice.equals("2")) {

				
				fightSequence();
				
				System.out.println("");
				System.out.println("\tYou defeat the Guard, and though he dropped his sword and armour, I haven't figured out how to");
				System.out.println("\tcode a method where you can pick it up and equip it, so just stick with what you have");
				System.out.println("\tfor now and I'll work on that some more later");
				System.out.println("");
				System.out.println("\tWhat do you want to do?");
				System.out.println("\t> 1. Walk into the town");
				System.out.println("\t> 2. Walk back to the forest");
				
				String townGateFinalChoice;
				townGateFinalChoice = input.nextLine();
				
				if (townGateFinalChoice.equals("1")) {
					townNovac(); 
					
				}
				else if (townGateFinalChoice.equals("2")) {
					forest();
				}
					
			}
		
			else if (townGateChoice.equals("3")) {
				forest();
			}
	}
	
	public void zombie() {
		System.out.println("");
		System.out.println("     .ed\"\"\"\" \"\"\"$$$$be.\r\n" + 
				"     -\"           ^\"\"**$$$e.\r\n" + 
				"   .\"                   '$$$c\r\n" + 
				"  /                      \"4$$b\r\n" + 
				" d  3                      $$$$\r\n" + 
				" $  *                   .$$$$$$\r\n" + 
				".$  ^c           $$$$$e$$$$$$$$.\r\n" + 
				"d$L  4.         4$$$$$$$$$$$$$$b\r\n" + 
				"$$$$b ^ceeeee.  4$$ECL.F*$$$$$$$\r\n" + 
				"$$$$P d$$$$F $ $$$$$$$$$- $$$$$$\r\n" + 
				"3$$$F \"$$$$b   $\"$$$$$$$  $$$$*\"\r\n" + 
				" $$P\"  \"$$b   .$ $$$$$...e$$\r\n" + 
				"  *c    ..    $$ 3$$$$$$$$$$eF\r\n" + 
				"    %ce\"\"    $$$  $$$$$$$$$$*\r\n" + 
				"     *$e.    *** d$$$$$\"L$$\r\n" + 
				"      $$$      4J$$$$$% $$$\r\n" + 
				"     $\"'$=e....$*$$**$cz$$\"\r\n" + 
				"     $  *=%4.$ L L$ P3$$$F\r\n" + 
				"     $   \"%*ebJLzb$e$$$$$b\r\n" + 
				"      %..      4$$$$$$$$$$\r\n" + 
				"       $$$e   z$$$$$$$$$$ \r\n" + 
				"        \"*$c  \"$$$$$$$P\"\r\n" + 
				"          \"\"\"*$$$$$$$\"\r\n" + 
				"");
		System.out.println("");
	}
		
	public void enemyAttack() {

		System.out.println("\t\t\t# The " + enemy + " is left with " + eHP + " HP #");
		System.out.println("\t\t-----------------------------------------------------");
	
		
		pHP -= eAtk;
	
		System.out.println("\t\tYou were attacked by " + enemy + " and took " + eAtk + " damage.");
		System.out.println(" ");

	}
	
	public void pDead() {
		System.out.println("\t\t#######################");
		System.out.println("\t\t#                     #");
		System.out.println("\t\t# YOU                 #");
		System.out.println("\t\t#       ARE           #");
		System.out.println("\t\t#             DEAD    #");
		System.out.println("\t\t#                     #");
		System.out.println("\t\t#######################");
		eHP = resetHP;
		
		playerSetUp();
	}
	
	public void enemyDropPotion() {
		numHealthPotions++;
		System.out.println("\t\tAwesome! " + enemy + " dropped a Health Potion");
		System.out.println("\t\tYou now have " + numHealthPotions);
		System.out.println(" ");
	}
	
	public void enemyDead() {
		
		System.out.println("\t\t#######################");
		System.out.println("\t\t#                     #");
		System.out.println("\t\t#         ENEMY       #");
		System.out.println("\t\t#                     #");
		System.out.println("\t\t#       DEFEATED!     #");
		System.out.println("\t\t#                     #");
		System.out.println("\t\t#######################");
		System.out.println(" ");
		
		enemyDropPotion();
	}
	
	public void pPetrified() {
		String cannotMove;
		cannotMove = input.nextLine();
		
		if (cannotMove.equals ("1")) {
			System.out.println("You're petrified, frozen to the spot, and can do absolutely nothing!");
		}
		else if (cannotMove.equals ("2")) {
			System.out.println("Absolutely nothing can be done when you're this scared!!");
		}
		else if (cannotMove.equals ("3")) {
			System.out.println("Like a statue! Frozen to the spot!");
		}
		else {
			System.out.println("Invalid Command!");
		}
	}

	public void findRandomItem() {
		
		if (rand.nextInt(100) < healthPotionFindChance) {
			numHealthPotions++;
			System.out.println(" ");
			System.out.println("In your travels, you happened upon a Health Potion");
			System.out.println("You now have " + numHealthPotions);
			System.out.println(" ");
			
		}
	}

	public void playerSetUp() {
		
		String nameConfirm;
		pHP = 100;
		pWeapon = "Fist";
		System.out.println("HP: " + pHP);
		System.out.println("Current Weapon: " + pWeapon);
		
		System.out.println("You wake up in a forest, unsure of how you got there");
		System.out.println("A vauge recollection of a bar, merriment, and countless drinks");
		System.out.println("You stand up, stretch, and take a deep breathe...");
		System.out.println("If you could only remember your name, that would be a good start...");
		System.out.println("Choose a name to call yourself for now");
		
		pName = input.nextLine();
		
		System.out.println("");
		System.out.println("You want to call yourself " + pName + "?");
		System.out.println("> 1. Yes");
		System.out.println("> 2. No");
		
		nameConfirm = input.nextLine();
		
		if (nameConfirm.equals ("1")) {
			
			System.out.println("Alright, your name is now " + pName + "! Let's begin...!");
			
		}
		
		else if (nameConfirm.equals ("2")) {
			
			playerSetUp();
		}
		
		
		
		
	}
	
	public void hallZombieDefeated() {
		
		System.out.println("");
		
System.out.println("\tAfter defeating the " + enemy + " you sit for a moment...that was close!");
		System.out.println("\tTime to make a choice, what do you want to do now?");
		System.out.println("\t> 1. Inspect the " + enemy + "for items.");
		System.out.println("\t> 2. Leave the Town Hall, head back to the NoVac sign");
		System.out.println("\t> 3. Explore the Town Hall further");
		
		String zombieDeadChoice;
		zombieDeadChoice = input.nextLine();
		
		if (zombieDeadChoice.contentEquals("1")) {
			
			specialItem = "Blacksmith Key";
			blacksmithKey++;
			System.out.println("\t# You found a " + specialItem + "! I wonder what that's for...? #");
			
			
		}
		
		else if (zombieDeadChoice.contentEquals("2")) {
			townNovac();
		}
		
		else if (zombieDeadChoice.contentEquals("3")) {
			deepHall();
		}
		
		
	}
	
	
	public void sitrep() {
		
		System.out.println("\t# HP: " + pHP + " #");
		System.out.println("\t# Weapon: " + pWeapon + " #");
		System.out.println("\tHealth Potions: x" + numHealthPotions + " #");
		System.out.println("\n");
		
	}

	public void fightSequence() {
		
		if (pWeapon == ("Knife(30)")) {
			pAtk = 30 + (pHP / 2);
		}
		
		else if (pWeapon == ("Sword(43)")) {
			pAtk = 43 + (pHP / 2);
		}
		
		else {
			pAtk = 10 + (pHP / 2);
		}
		
		while (eHP > 0 && pHP > 0) {
			
			System.out.println("");
			System.out.println("\t# HP: " + pHP + " # Atk: " + pAtk + " # " + enemy + " HP: " + eHP + " # " + enemy + " Atk: " + eAtk + " #");
			System.out.println("\t# You step up to the " + enemy + " prepared for battle! #");
			System.out.println("\tWhat do you want to do");
			System.out.println("\t> 1. Attack with your " + pWeapon);
			System.out.println("\t> 2. Drink a Health Potion");
			System.out.println("\t> 3. Run!");
			
			String battleChoice;
			battleChoice = input.nextLine();
			
			if (battleChoice.contentEquals("1")) {
		
				System.out.println("\t\t# You attack the " + enemy + " #");
				System.out.println(" ");
				
				
				eHP -= pAtk;		
				
				System.out.println("\t\tYou lash out with your " + pWeapon + " at the " + enemy);	
				System.out.println("\t\tYou landed a couple of hits and dealt " + pAtk + " damage.");
				System.out.println(" ");
				
				if (eHP <= 0) {
					
					enemyDead();
					
					}
				
				else {
					
					enemyAttack();
					
				}
				
				if (pHP <= 0) {
					
					pDead();
				}
				
				else if (pHP > 0) {

						System.out.println("\t\t\t# You're still alive! #");
						System.out.println("");
				}
					
			
			} //option 1 end
		
		
		if (battleChoice.equals("2")) {
			
			if (numHealthPotions > 0) {
				
				drinkPotion();
				
			}
				
				else {
					System.out.println ("\t\tYou reach for a health potion but... nothing there!");
				}
			
		} //battleChoice 2 end
		
		if (battleChoice.contentEquals("3")) {
			
			System.out.println("You ran away from the fight, all the way back to the forest!");
			
			forest();
			
		} //battleChoice 3 end
		
		} //while loop end
			
	} //fight sequence end
	
	
	public void townNovac() {
		
		System.out.println("    _   __         _    __                               \r\n" + 
				"   / | / /___     | |  / /___ ______                     \r\n" + 
				"  /  |/ / __ \\    | | / / __ `/ ___/                     \r\n" + 
				" / /|  / /_/ /    | |/ / /_/ / /__                       \r\n" + 
				"/_/ |_/\\____/     |___/\\__,_/\\___/_______________________\r\n" + 
				"                                /_____/_____/_____/_____/");
		
		sitrep();
		
		System.out.println("");
		System.out.println("\tAs you enter the town, it dawns on you how quiet it is");
		findRandomItem();
		System.out.println("\tYou see a sign, and have to make a choice");
		System.out.println("");
		
		
		System.out.println("\tWhich way would you like to go?");
		System.out.println("\t> 1. Blacksmith");
		System.out.println("\t> 2. Novac Town Hall");
		System.out.println("\t> 3. Mayor Dong's Home");
		
		String novacChoice;
		novacChoice = input.nextLine();
		
		if (novacChoice.contentEquals("1")) {
			
			blacksmith();
			
		}
		
		else if (novacChoice.contentEquals("2")) {
			
			novacTownHall();
			
		}

		else if (novacChoice.contentEquals("3")) {
	
			mayorDongHome();
			
}
		
		else {
			
			System.out.println("\tInvalid Command, try again");
			
		}
		
		
		
	}
	
	
	public void deepHall() {
		
		System.out.println("Method deepHall has not been written yet");
	}
	
	public void blacksmith() {
		
		System.out.println("    ____  __               __                  _ __  __  \r\n" + 
				"   / __ )/ /   ____ ______/ /___________ ___  (_) /_/ /_ \r\n" + 
				"  / __  / /   / __ `/ ___/ //_/ ___/ __ `__ \\/ / __/ __ \\\r\n" + 
				" / /_/ / /___/ /_/ / /__/ ,< (__  ) / / / / / / /_/ / / /\r\n" + 
				"/_____/_____/\\__,_/\\___/_/|_/____/_/ /_/ /_/_/\\__/_/ /_/ \r\n" + 
				"                                                         ");
		
		sitrep();
		findRandomItem();
		blacksmithDecision();
		
	}

	public void novacTownHall() {
		
		System.out.println("  ______                       __  __      ____\r\n" + 
				" /_  __/___ _      ______     / / / /___ _/ / /\r\n" + 
				"  / / / __ \\ | /| / / __ \\   / /_/ / __ `/ / / \r\n" + 
				" / / / /_/ / |/ |/ / / / /  / __  / /_/ / / /  \r\n" + 
				"/_/  \\____/|__/|__/_/ /_/  /_/ /_/\\__,_/_/_/   \r\n" + 
				"                                               ");
		
		if (pWeapon == ("Knife(30)")) {
			pAtk = 30 + (pHP / 2);
		}
		
		else if (pWeapon == ("Sword(43)")) {
			pAtk = 43 + (pHP / 2);
		}
		
		else {
			pAtk = 10 + (pHP / 2);
		}
		
		enemy = ("Zombie");
		eAtk = rand.nextInt(maxEAtk);
		eHP = rand.nextInt(maxEHP);
		eWeapon = ("Bite");
		
		sitrep();
		
		
		System.out.println("\tYou walk up to the Town Hall door...it's ajar, and there appears to be a trail of blood leading inside.");
		System.out.println("\tYou push the door open, and only realise how silent it was when the door creeeeeeeaks...");
		System.out.println("");
		System.out.println("\tTime to make a choice...");
		System.out.println("\t> 1. Go back to Novac Sign");
		System.out.println("\t> 2. Enter the door");
		System.out.println("\t> 3. Call out to see if someone is in there");
		
		String hallEntryChoice;
		
		hallEntryChoice = input.nextLine();
		
		if (hallEntryChoice.contentEquals("1")) {
			
			townNovac();
			
		}
		
		else if (hallEntryChoice.contentEquals("2")) {
			
			enterTownHall();
			
		}
		
		else if (hallEntryChoice.contentEquals("3")) {
			
			System.out.println("");
			System.out.println("\t# 'SHRREEIEEIIEIEIEIEIEIIIEEEEEEEKKKK!' #");
			System.out.println("");
			System.out.println("\tA terrifying scream pearces your ears...");
			System.out.println("\tBlood trickles from your nose... you feel your health plummet!");
			pHP = pHP - 10;
			sitrep();
			System.out.println("");
			
			System.out.println("\tIn your petrified state, frozen to the spot, you hear foots step...");
			System.out.println("\tThe get louder and louder and LOUDER");
			System.out.println("");
			zombie();
			System.out.println("");
			System.out.println("\tFrom the darkness, a " + enemy + " lunges out and grabs you");
			System.out.println("\tYou have to do something " + pName + "! What will you do?");
			System.out.println("\t> 1. Nothing");
			System.out.println("\t> 2. Nothing");
			System.out.println("\t> 3. Nothing");
			
			pPetrified();
			
			System.out.println("\tYou scurry out of the " + enemy + "'s grip, and stand!");
			
			fightSequence();
			
			hallZombieDefeated();
			
			
			
			
			
		}
	}
	
	public void mayorDongHome() {
		
		System.out.println("    __  ___                      _          __  __                   \r\n" + 
				"   /  |/  /___ ___  ______  ____( )_____   / / / /___  ____ ___  ___ \r\n" + 
				"  / /|_/ / __ `/ / / / __ \\/ ___/// ___/  / /_/ / __ \\/ __ `__ \\/ _ \\\r\n" + 
				" / /  / / /_/ / /_/ / /_/ / /    (__  )  / __  / /_/ / / / / / /  __/\r\n" + 
				"/_/  /_/\\__,_/\\__, /\\____/_/    /____/  /_/ /_/\\____/_/ /_/ /_/\\___/ \r\n" + 
				"             /____/                                                  ");
		
		System.out.println("\tStanding outside the Mayor's home, you can see that it's been a while since anyone was here.");
		System.out.println("\tThe grass is overgrown, the bushes unkept, and the door is stuck");
		System.out.println("\tA sign on the door reads:");
		System.out.println("");
		System.out.println("\t#Who makes it, has no need of it. #");
		System.out.println("\t#Who buys it, has no use for it. #");
		System.out.println("\t#Who uses it, can neither see nor feel it. #");
		System.out.println("\t#What is it? #");
		System.out.println("Answer the Riddle (lowercase):");
		
		String riddle;
		riddle = input.nextLine();
		
		if (riddle.contentEquals("coffin")) {
			
			enterDongHome();
		}
		
		else {
			
		townNovac();
		
		}
	}
	
	public void enterTownHall() {
		System.out.println("");
		System.out.println("\t# 'CRRRREEEEAAAAAAAAAAAAAAAAAAAAKKK!' #");
		System.out.println("");
		System.out.println("\tThe door shudders as it opens, and a cold air sweeps over you");
		System.out.println("\tBlood trickles from your nose... you feel your health plummet!");
		pHP = pHP - 15;
		sitrep();
		System.out.println("");
		
		System.out.println("\tIn your petrified state, frozen to the spot, you hear foots step...");
		System.out.println("\tThe get louder and louder and LOUDER");
		System.out.println("");
		zombie();
		System.out.println("");
		System.out.println("\tFrom the darkness, a " + enemy + " lunges out and grabs you");
		System.out.println("\tYou have to do something " + pName + "! What will you do?");
		System.out.println("\t> 1. Nothing");
		System.out.println("\t> 2. Nothing");
		System.out.println("\t> 3. Nothing");
		
		pPetrified();
		
		System.out.println("\tYou scurry out of the " + enemy + "'s grip, and stand!");
		
		fightSequence();
		
		hallZombieDefeated();
	}
	
	public void cursedChild() {
		
		
		eAtk = rand.nextInt(maxEAtk);
		eHP = rand.nextInt(maxEHP);
		String choiceCursedChild;
		choiceCursedChild = input.nextLine();
		
		if (choiceCursedChild.contentEquals("1")) {
			
			System.out.println("");
			System.out.println("\tYou call out to the child, but you're ignored.");
			System.out.println("\tThe fear pumps through you, but you're brave, and you gain 25HP!");
			pHP = pHP + 25;
			System.out.println("\tYou call out a little louder, and the child looks directly at you.");
			System.out.println("\tYou see rage in her eyes, and black veins like a web across her skin"
					+ "\tYou realise she's cursed"
					+ "\tShe screams as she lunges at you!"
					+ "\t");
			
			fightSequence();
			
		}
		
		else if (choiceCursedChild.contentEquals("2")) {
			
			System.out.println("");
			System.out.println("\tYou draw your " + pWeapon + " and approach the sobbing child...");
			System.out.println("\tThe adrenaline pumps through you, like a power up, and you gain 50hp!");
			pHP = pHP + 50;
			System.out.println("\tYou see rage in her eyes, and black veins like a web across her skin"
					+ "\tYou realise she's cursed"
					+ "\tShe screams as she lunges at you!"
					+ "\t");
			
			fightSequence();
			
		}
		
		else if (choiceCursedChild.contentEquals("3")) {
			
			
			townNovac();
		}
		
		else {
			
			System.out.println("Invalid Command");
			cursedChild();
		}
		
	}
	
	public void enterDongHome() {
		
		enemy = "Cursed Child";
		eHP = 140;
		eAtk = 36;
		
		System.out.println("");
		System.out.println("\tYou enter Mayor Dong's Home");
		System.out.println("\tIn the corner, a child is curled up, rocking back and forth");
		System.out.println("\tThe silence is broken by a gentle sob");
		System.out.println("");
		System.out.println("\tWhat will you do next " + pName + "?");
		System.out.println("\t> 1. Comfort the child");
		System.out.println("\t> 2. Attack the child");
		System.out.println("\t> 3. Go back");
		
		
		
		
	}
	
}
