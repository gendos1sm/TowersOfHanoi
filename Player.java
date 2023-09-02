/**
 * The interface <b>Player</b> is the interface which defines two methods play and getScore,
 * which are used in class <b>HumanPlayer<b> to play the game.
 * The explanation of each method is given in HumanPlayer file.
 */

public interface Player {

    public abstract void play(HanoiTowerGame game);
    public abstract int getScore();
	
}