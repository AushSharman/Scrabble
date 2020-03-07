import java.util.Arrays;

//Daiana Morjolic .

import java.util.Scanner;

public class Player 
{
	//Instance Variables :
	private String playerName;
	private int playerScore = 0;
	private Frame playerFrame;

	//Constructor :
	public Player(String playerName)
	{
		this.playerName = playerName;
		this.playerFrame = new Frame();
	}
	
	//Getting Player Name :
	public String getPlayerName()
	{
		return playerName;
	}
	
	//Getting Player Frame :
	public Frame getFrame()
	{
		return playerFrame;
	}
	
	//Displaying Player Frame 
	//And selects 7 random tiles to the Frame .
	/*public void playerFrameDisplay()
	{
		playerFrame.Display();
		playerFrame.getFrame();
	}*/
	
	//Displaying Player Data (Name , Score) :
	public void displayPlayerData()
	{
		System.out.println("Player Name : " + playerName);
		System.out.println("Player Score : " + playerScore);
	}
	
	//Displaying Player Score :
	public static void displayPlayerScore()
	{

	}
	
	//method to trigger the randomly select method 
	//that allows each player to randomly select tiles from the pool .
	public char[] getPlayerFrame()
	{
		return playerFrame.getFrame();
	}
	
	//Resetting Player Names :
	public void resetPlayerInfo()
	{
		String playerName = "";
		playerScore = 0;
	}
}
