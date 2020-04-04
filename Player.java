import javax.naming.NameParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;

//Daiana Morjolic .

import java.util.Scanner;

public class Player 
{
	//Instance Variables :
	private String playerName;
//	private Scrabble scrabble;
	private int playerScore;
	private Frame playerFrame;
//	private int[] words;

	//Constructor :
	public Player(String playerName) {
		this.playerName = playerName;
		playerScore = 0;
		playerFrame = new Frame();
	}

	//Getting Player Name :
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerFrame(Frame playerFrame) {
		this.playerFrame = playerFrame;
	}

	public int getPlayerScore(){
		return playerScore;
	}
	
	//Getting Player Frame :
	public Frame getFrame() {
		return playerFrame;
	}

	public void increaseScore(int score){
		playerScore += score;
	}

	public void decreaseScore(int score){
		playerScore -= score;
	}
	
	//Displaying Player Frame 
	//And selects 7 random tiles to the Frame .
	/*public void playerFrameDisplay()
	{
		playerFrame.Display();
		playerFrame.getFrame();
	}*/
	
	//Displaying Player Data (Name , Score) :
	public void displayPlayerData() {
		System.out.println("Player Name : " + playerName);
		System.out.println("Player Score : " + playerScore);
	}


	public static boolean isWordInFile(String word) {
		try {
			Scanner readFile = new Scanner(new File("C:\\Users\\Ayush Larma\\Downloads\\dictionary.txt"));
			while (readFile.hasNext()) {
				if (readFile.next().equals(word.toUpperCase())) return true;
			}
		} catch (FileNotFoundException ignored) {}
		return false;
	}

	public static void challenge(String word, Player player){
		if (!isWordInFile(word)) {
			player.decreaseScore(Pool.getWordScore(word));
			for (int index = 0; index < word.length(); index++) {
				Pool.addTileBack(new Tiles(word.charAt(index)));
			}
			for (int index = 0; index < Board.pos.size(); index = index + 2) {
				Board.removeTileFromBoard(Board.pos.get(index), Board.pos.get(index + 1));
			}
			System.out.println(player.getPlayerName() + "'s points are now " + player.getPlayerScore());
		}
		else{
			System.out.println("Challenge was unsuccessful - Miss a turn !");
		}
	}
	
	//Resetting Player Names :
	public void reset() {
		playerName = "";
		playerScore = 0;
		playerFrame = null;
	}

	public static void main(String[] args) {
//		Scrabble scrabble = new Scrabble();
		Pool pool = new Pool();
		Board board = new Board();
		Player player = new Player("ji");
	}

}
