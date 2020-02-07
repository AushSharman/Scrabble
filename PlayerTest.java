public class PlayerTest {
    static Player player;
    static Pool pool;
    static Frame frame;


    public static void main(String[] args) {
        pool = new Pool();
        frame = new Frame();
        player = new Player("Johnny");

        //Test if number of Tiles in the Bag are 100 - passes
        System.out.println(pool.getTotalTiles() == 100);
        System.out.println(pool.toString());

        //Test to see whether bag is empty
        System.out.println(pool.getNumberOfTilesInPool().isEmpty());

        //Test to see the value of the tiles - passes
        System.out.println(pool.getLetterScore('Z') == 10);
    }
}
