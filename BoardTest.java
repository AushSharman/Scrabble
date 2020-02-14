
public class BoardTest 
{
	public static void main(String[] args)
	{
		Board board = new Board();
		
		//Board Display Test :
		board.boardDisplay();
		
		//Input Test : 
		board.getBoardInput();
		board.boardDisplay();
		board.getBoardInput();
		board.boardDisplay();
		
		//When using the 2 words : CAR DOG 
		//the expected results are :
		System.out.println("Expected Results : A and G ");
		board.tilePositionTestMethod();
		
		//Reset Test :
		board.boardReset();
		board.boardDisplay();
	}
}
