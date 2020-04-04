import javax.naming.NameParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

//Daiana Morjolic .

import java.util.Scanner;

public class Player 
{
	//Instance Variables :
	private String playerName;
	private int playerScore;
	private Frame playerFrame;
//	private Scanner readFile;

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

	//method to trigger the randomly select method 
	//that allows each player to randomly select tiles from the pool .

	public void challenge(String word, Player player) {
		try {
			Scanner readFile = new Scanner(new File("C:\\Users\\Ayush Larma\\Downloads\\dictionary.txt"));
			while (readFile.hasNext()){
				System.out.println(readFile.next());
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		/*player.decreaseScore(Pool.getWordScore(word) );
		for (int index =0; index < word.length(); index++){
			Pool.addTileBack(new Tiles(word.charAt(index)));
		}
		for (int index = 0; index < Board.pos.size(); index=index+2){
			Board.removeTileFromBoard(Board.pos.get(index), Board.pos.get(index+1));
		}*/

	}
	
	//Resetting Player Names :
	public void reset() {
		playerName = "";
		playerScore = 0;
		playerFrame = null;
	}

	public static void main(String[] args) {
		Pool pool = new Pool();
		Board board = new Board();
		Player player = new Player("ji");
		player.challenge("HI", player);
	}

}
