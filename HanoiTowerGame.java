/**
 * The class <b>HanoiTowerGame</b> is the class that implements the Hanoi Tower Game. 
 * It contains the game board and tracks its progress. It automatically maintains
 * the current state of the game as players are making moves.
 */

import java.lang.Math;

public class HanoiTowerGame {

	//This will point to the array of three towers (type of towers LinkedStack)
	private Stack[] towerValues;

	//your code here
	/**
	 * level records the number of moves that have been made so far.
	 */
	private int level;

	/**
	 * maxLevels is the maximum number of allowed moves each player can make.
	 */
	private int maxLevels;

	/**
	 * gameState records the current state of the game.
	 */
	private GameState gameState;

	/**
	 * disks is the number of disks in the game being played.
	 */
	private int disks;

	/**
	 * default constructor, for a game with 3 disks.
	 */
	public HanoiTowerGame() {
		disks = 3;
		level = 0;
		maxLevels = 2*((int)Math.pow(2,disks)-1);
		gameState = GameState.PLAYING;

		towerValues = new Stack [4]; // four slots with one for "invisible" holder stack for toString
		towerValues[0] = new LinkedStack();
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();
		towerValues[3] = new LinkedStack(); // extra holder "invisible" stack used to help print the game board in toString
		for (int i = disks; i >=1; i--) {
			towerValues[0].push(i);
		}
	}

	/**
	 * constructor allowing to specify the starting number of disks for the game.
	 * 
	 * @param disks   the number of disks in the game
	 */
	public HanoiTowerGame(int disks) {
		this.disks = disks;
		level = 0;
		maxLevels = 2*((int)Math.pow(2,disks)-1);
		gameState = GameState.PLAYING;

		towerValues = new Stack [4]; // four slots with one for "invisible" holder stack for toString
		towerValues[0] = new LinkedStack();
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();
		towerValues[3] = new LinkedStack(); // extra holder "invisible" stack used to help print the game board in toString
		for (int i = disks; i >=1; i--) {
			towerValues[0].push(i);
		}
	}

	// all methods should be documented: purpose of the method, input, and output
	// and where it is used in the assignment

	/**
	 * getter for the variable disks, used to set the number of starting disks for the game
	 * 
	 * @return the value of disks
	 */
	public int getDisks() {
		return disks;
	}

	/**
	 * getter for the variable level, used to keep track of number of moves made by each player
	 * 
	 * @return the value of level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * getter for the variable maxLevels, used to set the maximum value of moves for each round
	 * 
	 * @return the value of maxLevels
	 */
	public int getMaxLevels() {
		return maxLevels;
	}

	/**
	 * getter for the variable gameState, used to check the state of the game and who is winner or loser
	 * 
	 * @return the value of gameState
	 */
	public GameState getGameState() {
		return gameState;
	}

	/**
	 * returns the number of disks at tower index i. Used to check the number of disks at the stack
	 * 
	 * @param i the index of the tower in the array of 3 stacks
	 * @return the number of disks at tower index i.
	 */
	public int getDisksAtTower(int i) {
		return towerValues[i].size();
	}

   /**
    * Method checkWinner takes no parameters and checks the state of the game
    * If conditions are satisfied to change gameState from PLAYING,
    * it is changed to WINNER or LOSER.
  	*/
	public void checkWinner() {
		if ((towerValues[2].size() == disks) && (getLevel()<=getMaxLevels())) {
			gameState = GameState.WINNER;
		}
		if ((towerValues[2].size() < disks) && (getLevel()==getMaxLevels())) {
			gameState = GameState.LOSER;
		}
	}

   /**
	* This method is called by the player to play and move one disk from source tower to destination tower.
	* If the move is valid, the game field, as well as the level of the game is updated.
	* checkwinner method is called after the valid move to check if gameState was updated.
   	* @param sourceTower
    *  the array index of the tower from which the disk is moved.
   	* @param destTower
    *  the array index of the tower to which the disk is moved.
  	*/
	public void play(int sourceTower, int destTower) {

		if (!towerValues[sourceTower].isEmpty() && (towerValues[destTower].isEmpty() || ((int)towerValues[destTower].peek() > (int)towerValues[sourceTower].peek()))) {
			int temp = (int)towerValues[sourceTower].pop();
			towerValues[destTower].push(temp);
			level++;
			checkWinner();
		}
		else {
			System.out.println("Invalid move!");
		}
	}

	final String NEW_LINE = System.getProperty("line.separator");

   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	*
   	* @return
    *  String representation of the game
  	*/
	public String toString() {


		String str = "";
		str += "Tower 1";
		str += NEW_LINE;

		if (towerValues[0].isEmpty()) {
			for (int i = 1; i<=disks; i++) {
				str += NEW_LINE;
			}
		}
		if (towerValues[0].size()==getDisks()) {
			for (int i = 1; i <= disks; ++i) {
				for (int j = 1; j <= i; ++j) {
					str += "-";
				}
				str += NEW_LINE;
			}
		}
		if (!towerValues[0].isEmpty() && towerValues[0].size()!=getDisks()) {
			int size_0 = towerValues[0].size();
			int towerEmpty_0 = disks - size_0;

			for (int i = 1; i<=towerEmpty_0; ++i) {
				str += NEW_LINE;
			}
			for (int i = 1; i <= size_0; ++i) {
				int pop_0 = (int) towerValues[0].pop();
				towerValues[3].push(pop_0);
				for (int j = 1; j <= pop_0; ++j) {
					str += "-";
				}
				str += NEW_LINE;
			}
			while (!towerValues[3].isEmpty()){
				int pop_temp = (int) towerValues[3].pop();
				towerValues[0].push(pop_temp);
			}
		}

		str += "Tower 2";
		str += NEW_LINE;

		if (towerValues[1].isEmpty()) {
			for (int i = 1; i<=disks; i++) {
				str += NEW_LINE;
			}
		}
		if (towerValues[1].size()==getDisks()) {
			for (int i = 1; i <= disks; ++i) {
				for (int j = 1; j <= i; ++j) {
					str += "-";
				}
				str += NEW_LINE;
			}
		}
		if (!towerValues[1].isEmpty() && towerValues[1].size()!=getDisks()) {
			int size_1 = towerValues[1].size();
			int towerEmpty_1 = disks - size_1;

			for (int i = 1; i<=towerEmpty_1; ++i) {
				str += NEW_LINE;
			}
			for (int i = 1; i <= size_1; ++i) {
				int pop_1 = (int) towerValues[1].pop();
				towerValues[3].push(pop_1);
				for (int j = 1; j <= pop_1; ++j) {
					str += "-";
				}
				str += NEW_LINE;
			}
			while (!towerValues[3].isEmpty()){
				int pop_temp = (int) towerValues[3].pop();
				towerValues[1].push(pop_temp);
			}
		}

		str += "Tower 3";
		str += NEW_LINE;

		if (towerValues[2].isEmpty()) {
			for (int i = 1; i<=disks; i++) {
				str += NEW_LINE;
			}
		}
		if (towerValues[2].size()==getDisks()) {
			for (int i = 1; i <= disks; ++i) {
				for (int j = 1; j <= i; ++j) {
					str += "-";
				}
				str += NEW_LINE;
			}
		}
		if (!towerValues[2].isEmpty() && towerValues[2].size()!=getDisks()) {
			int size_2 = towerValues[2].size();
			int towerEmpty_2 = disks - size_2;

			for (int i = 1; i<=towerEmpty_2; ++i) {
				str += NEW_LINE;
			}
			for (int i = 1; i <= size_2; ++i) {
				int pop_2 = (int) towerValues[2].pop();
				towerValues[3].push(pop_2);
				for (int j = 1; j <= pop_2; ++j) {
					str += "-";
				}
				str += NEW_LINE;
			}
			while (!towerValues[3].isEmpty()){
				int pop_temp = (int) towerValues[3].pop();
				towerValues[2].push(pop_temp);
			}
		}

		return str;

	}

}
