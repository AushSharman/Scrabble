
//GrandNeedleWorker - ayush sharma - 18301681

import java.util.*;
import java.util.ListIterator;

public class Pool {
    private Tiles tilesObj;
    //private static Iterator iterator;
    private static LinkedList<Tiles> numberOfTilesInPool;
    private static int[] letterCount = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};    //Number OF tiles


    public Pool() {
        numberOfTilesInPool = new LinkedList<Tiles>();
        //frame = new Frame();
        createTilePoint();
    }


    /*Create something to hold the Tile and it's count*/
    private void createTilePoint() {
        char[] tiles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_".toCharArray();
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
        return numberOfTilesInPool.isEmpty();
    }


    /*public  void swap(Frame frame, int numberOfSwaps) {
        for (int i = 0; i < numberOfSwaps; i++) {
            int random = (int) (Math.random() * numberOfTilesInPool.size());
            Tiles tiles = numberOfTilesInPool.get(random);
            if(!tileLimit(tiles)){
                frame.getFrame()[i] = tiles.getLetter();
                reduceTileCount(tiles.getLetter());
            } else{
                swap(frame, numberOfSwaps);
                break;
            }
        }
    }*/

    // public void addTileBack(char letter) {}


    public static void reduceTileCount(Tiles tile) {                   //Reduce the Number of tileCount of a tile in the LinkedList
        Tiles.setLetterCount(tile, tile.getLetterCount()-1);
    }
//
//    public void reduceTiles(char []frame){
//        for(int i = 0; i < frame.length; i++){
//            reduceTileCount(frame[i]);
//        }
//    }
    //Whenever Player takes tiles out, reduce the tile count from the array

    public static int getLetterCountInPool(char letter) {
        for (Tiles tiles : numberOfTilesInPool) {
            if (tiles.getLetter() == letter) {
                return tiles.getLetterCount();
            }
        }
        return 0;
    }

    //Get the indexes with the Frame[] is 0 - and overwrite
    public static void drawTiles(char[] frame, int numberOfTilesWantToDraw) {
        for (int index = 0; index < numberOfTilesWantToDraw; index++) {
            if (frame[index] != 0) continue;
            int random = (int) (Math.random() * numberOfTilesInPool.size());    //RandomIndex
            Tiles randomTile = numberOfTilesInPool.get(random);                 //Random Tile Object
            if (!Tiles.tileLimit(randomTile)){
                frame[index] = randomTile.getLetter(); //Gets a random letter from the LL - and pops it into the player frame
                reduceTileCount(randomTile);
            }
            else{
                System.out.println("The tile chosen :"+randomTile.getLetter()+" is empty ");
                drawTiles(frame, index);                    //If Tile is empty - pick another tile
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
        Player player = new Player("John");
    }



}
