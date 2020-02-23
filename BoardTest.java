
public class BoardTest 
{
	public static void main(String args[])
	{
		Board board = new Board();
		Frame frame = new Frame();
		
		System.out.println(frame);
		
		//Board Display Test :
		board.boardDisplay();
		
		//Scrabble game simulation test :
		//Simulates a 2 round scrabble game where player can input tiles from the provided frame on screen .
		for(int i = 0; i < 2; i++)
		{
			board.getBoardInput();
			board.boardDisplay();
		}
		
		//Testing tile position :
		System.out.println("Tile on position row : 8 column : 8 is : " + board.getTile(8, 8));
		
		//Reset Test :
		board.boardReset();
		board.boardDisplay();
	}
}
