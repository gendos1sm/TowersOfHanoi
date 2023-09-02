/**
 * The class <b>HumanPlayer</b> is the class that controls the human's play and implements the interface Player.
 * The class is used to keep count of the score of the game for each of two players and
 * used push the game forward according to the instructions.
 */

import java.util.*;
import java.io.Console;

public class HumanPlayer implements Player {

	// your code here
    /**
     * score keeps track of the players' score.
     */
    private int score = 0;

    /**
     * getter for the variable score
     * 
     * @return the value of score
     */
    public int getScore() {
        return score;
    }

    /**
    * This method play is used to push the game forward. It prints out the simple instructions and game's board.
    * It also uses the loop to push the game forward by taking in inputs from players and updating the game, 
    * as well as using HanoiTowerGame to update the state of the game and check for winners.
    * @param game
    *  a reference to a HanoiTowerGame.
    */
    public void play(HanoiTowerGame game) {

        System.out.println(game);
        System.out.println("Your goal is to move " + game.getDisks() + " disks from tower 1 to 3");
        System.out.println("Only one simple rule: no large disk on the top of a smaller one!");


        while(game.getGameState() == GameState.PLAYING) {
            System.out.println("Moves played " + game.getLevel() + " Max " + game.getMaxLevels());
            System.out.println("Enter the source and the destination towers each on a single line (values between 1 and 3):");
            String user_input1, user_input2;
            int parse_user_input1, parse_user_input2;
            user_input1 = Utils.console.readLine();
            parse_user_input1 = Integer.parseInt(user_input1) - 1;
            user_input2 = Utils.console.readLine();
            parse_user_input2 = Integer.parseInt(user_input2) - 1;
            if (parse_user_input1 < 0 || parse_user_input1 > 2 || parse_user_input2 < 0 || parse_user_input2 > 2) {
                System.out.println("Try again! The entry shoud be between 1 and 3!");
            }
            else {
                game.play(parse_user_input1, parse_user_input2);
                System.out.println(game);
            }

        }
        if (game.getGameState() == GameState.WINNER) {
            score++;
            System.out.println("Moves played " + game.getLevel() + " Max " + game.getMaxLevels());
            System.out.println("You did it within the allowed number of moves!");
            System.out.println("Your score is " + getScore());
        }
        if (game.getGameState() == GameState.LOSER) {
            System.out.println("Moves played " + game.getLevel() + " Max " + game.getMaxLevels());
            System.out.println("You finished the allowed number of moves!");
            System.out.println("Your score is " + getScore());
        }

    }

}