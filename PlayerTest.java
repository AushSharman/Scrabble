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
        System.out.println("The bag is empty : " + pool.getNumberOfTilesInPool().isEmpty());
        System.out.println("");

        //Test to see the value of the tiles - passes
        System.out.print("Getting the number of tiles for the letter Z");
        System.out.println(pool.getScoreOfTile('Z') == 10);
        //System.out.println("");


        //Test to see if the Letter Counts in the pool is reduced - passes
        //pool.reduceTiles(frame.getFrame());
        System.out.println(pool);


        //Test to see if method can find the score of a word - passes
        System.out.println(pool.getWordScore("cabbage") == 14);

        //Test to see whether the reduceTile method works
        //pool.reduceTileCount('Z');
        System.out.println(Pool.getLetterCountInPool('Z') == 0);
        
        //Frame Tests :
        System.out.println(frame);
        //Test to swap first 4 tiles on frame
        //frame.swap(frame, 4);
        System.out.println(frame);
        System.out.println("");
        
        //Test to check if frame is empty
      	System.out.println(frame.IsFrameEmpty());
      	System.out.println("");

        //Player Tests :
        //Displaying Player Names :
        player1.displayPlayerData();
        //player1.playerFrameDisplay();
        System.out.println("");

        player2.displayPlayerData();
        //player2.playerFrameDisplay();
    }
}