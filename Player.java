import java.util.Arrays;
import java.util.Scanner;

public class Player 
{
	//instance variables :
	private static int numberOfPlayers;
	private static String[] playerName = new String[4];
	//private Frame playerFrame;
	//private Pool pool;
	
	//constructor :
	public Player()
	{

	}
	
	//Getting Player Names :
	public static void getPlayerNames()
	{
		System.out.println("Enter Number of Players : ");
		Scanner sc = new Scanner(System.in);
		numberOfPlayers = sc.nextInt();
		
		if(numberOfPlayers == 1 || numberOfPlayers > 4)
		{
			System.out.println("Number of players not valid . ");
		}
		
		else
		{
			for(int i = 0; i < numberOfPlayers; i++)
			{
				System.out.println("Enter player name : ");
				Scanner input = new Scanner(System.in);
				playerName[i] = input.nextLine();
			}
		}
	}
	
	//Displaying Player Names :
	public static void displayPlayerName()
	{
		switch(numberOfPlayers)
		{
			case 2 :
			{
				System.out.println("Player One : " + playerName[0]);
				System.out.println("Player Two : " + playerName[1]);
				break;
			}
			
			case 3 :
			{
				System.out.println("Player One : " + playerName[0]);
				System.out.println("Player Two : " + playerName[1]);
				System.out.println("Player Three : " + playerName[2]);
				break;
			}
			
			case 4 :
			{
				System.out.println("Player One : " + playerName[0]);
				System.out.println("Player Two : " + playerName[1]);
				System.out.println("Player Three : " + playerName[2]);
				System.out.println("Player Four : " + playerName[3]);
				break;
			}
			
			default :
			{
				System.out.println("Names not found . ");
				break;
			}
		}
	}
	
	//Resetting Player Names :
	public static void playerNameReset()
	{
		Arrays.fill(playerName,null);
	}
	
	//access to the player's frame :
	//public Frame getFrame()
	
	//Player Score :
	//public Pool getPoints()
	
	public static void main(String[] args)
	{
		//Test 1 : Get Player Names :
		getPlayerNames();
		
		//Test 2 : Display Player Names :
		displayPlayerName();
		
		//Test 3 : Reset Player Names :
		playerNameReset();
	}
}
