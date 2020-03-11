import java.util.Arrays;

//Daiana Morjolic .

import java.util.Scanner;

public class Player 
{
	//Instance Variables :
	private String playerName;
	private static int playerScore = 0;
	private Frame playerFrame;

	//Constructor :
	public Player(String playerName) {
		this.playerName = playerName;
		playerFrame = new Frame();
	}

	//Getting Player Name :
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerFrame(Frame playerFrame) {
		this.playerFrame = playerFrame;
	}

	public static int getPlayerScore(){
		return playerScore;
	}
	
	//Getting Player Frame :
	public Frame getFrame() {
		return playerFrame;
	}

	public static void increaseScore(int score){
		playerScore += score;
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

	
	//Resetting Player Names :
	public void resetPlayerInfo() {
		playerName = "";
		playerScore = 0;
	}
//	 TODO: 11/03/2020 Can't seem to connect the Frame and the Player together

}
