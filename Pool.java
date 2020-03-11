
//GrandNeedleWorker - ayush sharma - 18301681

import java.util.*;

public class Pool {
    private static LinkedList<Tiles> numberOfTilesInPool;
    private static int[] letterCount = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};    //Number OF tiles


    public Pool() {
        numberOfTilesInPool = new LinkedList<Tiles>();
        char[] tiles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" .toCharArray();
        for (int j = 0; j < letterCount.length; j++) {
            numberOfTilesInPool.add(new Tiles(tiles[j], letterCount[j]));
        }
    }

    public int getScoreOfTile(char letter) {
        return Tiles.getLettervalueArray()[letter - 'A'];
    }
    //Allow access to the points of a tile

    public int getWordScore(String word) {
        int sum = 0;
        for (char letter : word.toCharArray()) {
            sum += getScoreOfTile(Character.toUpperCase(letter));
        }
        return sum;
    }
    //Get score of the word itself

    public int getTotalTiles() {
        int sum = 0;
        for (Tiles tiles : numberOfTilesInPool) {
            sum += tiles.getLetterCount();
        }
        return sum;
    }
    //Returns the number of tiles in the pool at the moment

    public void resetPool() {
        numberOfTilesInPool.clear();
    }
    //Since its a LL - clear it first


    public boolean isPoolEmpty() {
        boolean var = false;
        for (Tiles tiles : numberOfTilesInPool){
            var = tiles.getLetterCount() == 0;
            if (!var) return var;
        }
        return var;
    }
//    The LL is empty if the NumberOfOccurrances is 0;  i.e "A": 0, "B": 0, "C": 0


    public static void swap(Frame frame, int numberOfSwaps){}

    // public void addTileBack(char letter) {}



    public static void reduceTileCount(Tiles tile) {                   //Reduce the Number of tileCount of a tile in the LinkedList -
        System.out.println("The tile "+tile.getLetter() + "with "+tile.getLetterCount());                                                               // /*Reduce the Number of Occurrances of a particular Tile*/
        Tiles.setLetterCount(tile, tile.getLetterCount()-1);
    }

    public static int getLetterCountInPool(char letter) {
        for (Tiles tiles : numberOfTilesInPool) {
            if (tiles.getLetter() == letter) {
                return tiles.getLetterCount();
            }
        }
        return 0;
    }

    //Get the indexes with the Frame[] is 0 - and overwrite
    public static void drawTiles(Frame frame, int numberOfTilesWantToDraw) {
        for (int index = 0; index < numberOfTilesWantToDraw; index++) {
            if (frame.getFrame()[index] != 0) continue;
            int random = (int) (Math.random() * numberOfTilesInPool.size());    //RandomIndex
            Tiles randomTile = numberOfTilesInPool.get(random);                 //Random Tile Object
            if (!Tiles.tileLimit(randomTile)){
                frame.getFrame()[index] = randomTile.getLetter(); //Gets a random letter from the LL - and pops it into the player frame
                reduceTileCount(randomTile);
            }
            else{
                System.out.println("The tile chosen :"+randomTile.getLetter()+" is empty ");
                drawTiles(frame, numberOfTilesWantToDraw-index);                    //If Tile is empty - pick another tile
                System.out.println("Inside drawTiles v2");
            }
        }
    }

    public LinkedList<Tiles> getNumberOfTilesInPool() {
        return numberOfTilesInPool;
    }

    public String toString() {
        String result = "";
        for (Tiles tiles : numberOfTilesInPool) {
            result += tiles.getLetter() + " has " + tiles.getLetterCount() + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        System.out.println(pool);
        Player player = new Player("JOn");
        Frame frame = new Frame();
        System.out.println(player.getFrame());
        System.out.println(pool);

    }
// TODO: 11/03/2020 reduceTile method isnt working correctly


}
