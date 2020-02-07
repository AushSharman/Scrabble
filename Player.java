import java.util.Arrays;
import java.util.Scanner;

public class Player 
{
	//Instance Variables :
	private String playerName;
	private static int playerScore = 0;
	private Frame playerFrame;
	private Pool pool;
	
	//Constructor :
	public Player(String playerName , Frame playerFrame)
	{
		this.playerName = playerName;
		this.playerFrame = playerFrame;
		this.pool = pool;
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
	
	//Displaying Player Frame :
	public void playerFrameDisplay()
	{
		playerFrame.Display();
		playerFrame.getFrame();
	}
	
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
	//that allow each player to randomly select tiles from the pool .
	public void playerToFrame()
	{
		pool.assignToFrame();
	}
	
	//Resetting Player Names :
	public static void playerNameReset()
	{
		String playerName = "";
	}
	
	public static void main(String[] args)
	{	
		Frame frame = new Frame();
		Pool pool = new Pool();
		Player player1 = new Player("Daiana",frame);
		Player player2 = new Player("Suzane",frame);
		
		//Test 1 : Displaying Player Names :
		player1.displayPlayerData();
		player1.playerFrameDisplay();
		
		player2.displayPlayerData();
		player2.playerFrameDisplay();
		
		//Test 2 : Reset Player Data :
		//playerNameReset();
		
		//Test 3 : After Reset :
		//displayPlayerData();
	}
}
