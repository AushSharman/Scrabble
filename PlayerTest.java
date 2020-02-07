
public class PlayerTest 
{
	 static Player player;
	 static Pool pool;
	 static Frame frame;

	 public static void main(String[] args) 
	 {
		pool = new Pool();
		frame = new Frame();
		Player player1 = new Player("John");
		Player player2 = new Player("Mary");
		
		//Pool Tests :
		//Test if number of Tiles in the Bag are 100 - passes
		System.out.println(pool.getTotalTiles() == 100);
		System.out.println("");
		System.out.println(pool.toString());
		System.out.println("");
		
		//Test to see whether bag is empty
		System.out.println(pool.getNumberOfTilesInPool().isEmpty());
		System.out.println("");
		
		//Test to see the value of the tiles - passes
		System.out.println(pool.getLetterScore('Z') == 10);
		System.out.println("");
		 
		//Frame Tests :
		System.out.println(frame);
		//Test to swap first 4 tiles on frame
		frame.swap(frame, 4);
		System.out.println(frame);
		System.out.println("");
		    
		//Player Tests :
		//Displaying Player Names :
		player1.displayPlayerData();
		player1.playerFrameDisplay();
		System.out.println("");
			
		player2.displayPlayerData();
		player2.playerFrameDisplay();
	  }
}
