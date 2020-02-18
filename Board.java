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
				boardValue();
				System.out.print(board[row][column] + "|");
			}
			
			System.out.println();
			System.out.println("-------------------------------");
		}
	}
	
	public void boardValue() {
		
		//Triple Word Score
		if(row == 0 && column == 0 || row == 0 && column == 7 || row == 0 && column == 14 || row == 7 && column == 0 || row == 7 && column == 14 || row == 14 && column == 0 || row == 14 && column == 7 || row == 14 && column == 14) {
			board[row][column] = '*';
		}
		
		//Double Word Score
		if(row == 1 && column == 1 || row == 1 && column == 13 || row == 2 && column == 2 || row == 2 && column == 12 || row == 3 && column == 3 || row == 3 && column == 11 || row == 4 && column == 4 || row == 4 && column == 10 || row == 10 && column == 4 || row == 10 && column == 10 || row == 11 && column == 3 || row == 11 && column == 11 || row == 12 && column == 2 || row == 12 && column == 12 || row == 13 && column == 1 || row == 13 && column == 13) {
			board[row][column] = '=';
		}
		
		//Centre
		if(row == 7 && column == 7) {
			board[row][column] = '!';
		}
		
		//Triple Letter Score
		if(row == 1 && column == 5 || row == 1 && column == 9 || row == 5 && column == 1 || row == 9 && column == 1 || row == 5 && column == 1 || row == 5 && column == 5 || row == 5 && column == 9 || row == 5 && column == 13 || row == 9 && column == 1 || row == 9 && column == 5 || row == 9 && column == 9 || row == 9 && column == 13 || row == 13 && column == 5 || row == 13 && column == 9) {
			board[row][column] = '@';
		}
		
		//Double Letter Score
		if(row == 0 && column == 3 || row == 0 && column == 11 || row == 2 && column == 6 || row == 2 && column == 8 || row == 3 && column == 0 || row == 3 && column == 7 || row == 3 && column == 14 || row == 6 && column == 2 || row == 6 && column == 6 || row == 6 && column == 8 || row == 6 && column == 12 || row == 7 && column == 3 || row == 7 && column == 11 || row == 8 && column == 2 || row == 8 && column == 6 || row == 8 && column == 8 || row == 8 && column == 12 || row == 11 && column == 0 || row == 11 && column == 7 || row == 11 && column == 14 || row == 12 && column == 6 || row == 12 && column == 8 || row == 14 && column == 3 || row == 14 && column == 11) {
			board[row][column] = '+';
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