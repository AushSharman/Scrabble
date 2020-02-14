import java.util.Scanner;

public class Board 
{	
	//instance variables :
	private char[][] board;
	private int row;
	private int column;
	private int wordSize;
	
	//Constructor :
	public Board()
	{
		this.board = new char[15][15];
	}
	
	//Board Design Method :
	public void boardDisplay()
	{
		System.out.println("-------------------------------");
		
		for(row = 0; row < board.length; row++)
		{
			System.out.print("|");
			
			for(column = 0; column < board[row].length; column++)
			{
				System.out.print(board[row][column] + "|");
			}
			
			System.out.println();
			System.out.println("-------------------------------");
		}
	}
	
	//Getting tile input from user onto board :
	public void getBoardInput()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter word size : ");
		wordSize = input.nextInt();
		
		for(int i = 0; i < wordSize; i++)
		{
			System.out.println("Enter position on board : ");
			row = input.nextInt();
			column = input.nextInt();
			
			System.out.println("Enter tiles : ");
			board[row][column] = input.next().charAt(0);
		}
	}
	
	//TEST : ** TEMPORARY METHOD **
	//Displaying tile on a given position .
	public void tilePositionTestMethod()
	{
		System.out.println("Current tile on position 1 2 : ");
		System.out.println(board[1][2]);
		System.out.println("Current tile on position 5 7 : ");
		System.out.println(board[5][7]);
	}
	
	//Board Reset :
	public void boardReset()
	{
		for(row = 0; row < board.length; row++)
		{
			for(column = 0; column < board[row].length; column++)
			{
				board[row][column] = ' ';
			}
		}
	}
}
