import java.util.*;

public class Pool {
    private static Tiles tileObj = new Tiles();
    private static LinkedList<Tiles> numberOfTilesInPool;
    private static Frame frame = new Frame();
    private int[] letterCount = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};    //Number OF tiles


    public Pool() {
        numberOfTilesInPool = new LinkedList<Tiles>();
        createTilePoint();
    }

    private void createTilePoint() {
        char[] tiles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_".toCharArray();
        for (int j = 0; j < letterCount.length; j++) {
            numberOfTilesInPool.add(new Tiles(Character.toUpperCase(tiles[j]), letterCount[j]));
        }
    }

    public int getLetterScore(char letter) {
        return tileObj.getLettervalueArray()[Character.toUpperCase(letter) - 'A'];
    }
    //Allow access to the points of a tile

    public int getWordScore(String word) {
        int sum = 0;
        for (char letter : word.toCharArray()) {
            sum += getLetterScore(Character.toUpperCase(letter));
        }
        return sum;
    }
    //Get score of the word itself

    public int getTotalTiles() {
        int sum = 0;
        for (Tiles tiles : numberOfTilesInPool){
            sum += tiles.getLetterValue();
        }
        return sum;
        }
    //Returns the number of tiles in the pool at the moment

    public void resetPool() {
        numberOfTilesInPool.clear();
        createTilePoint();
    }
    //Since its a LL - clear it first and call the function to recreate it again

    public boolean isPoolEmpty() {
        return numberOfTilesInPool.isEmpty();
    }

    private void tileLimit(Tiles tile) {
        if (tile.getLetterValue() < 0) {
            throw new IllegalArgumentException("Cannot access anymore Tile " + tile.getLetter() + " as it doesn't exist " + tile.getLetterValue());
        }
    }
    //a validation method of sorts - checks to see if the number of tiles in letterCount array is not 0


    public void swap(int numberOfSwaps) {
        for (int i = 0; i < numberOfSwaps; i++) {
            int random = (int) (Math.random() * numberOfTilesInPool.size());
            Tiles tiles = numberOfTilesInPool.get(random);
            tileLimit(tiles);
            frame.getFrame()[i] = tiles.getLetter();
            reduceTileCount(tiles.getLetter());
        }
    }

    public void addTileBack(char letter) {}

    public int getLetterCount(char letter){
        return letterCount[Character.toUpperCase(letter) - 'A'];
    }

    public void setLetterCount(char letter, int value){
        tileLimit(new Tiles(letter, value));

    }

    //This function takes the frame and alters it and doesn't return anything.... Used in the Frame class by a PoolObj
    //Checks to  see if any tile in the array is not set to 0 ... if yes - then access to random tile;

    protected void reduceTileCount(char letter) {
        for (Tiles tiles : numberOfTilesInPool) {
            if (tiles.getLetter() == Character.toUpperCase(letter)) {
                tiles.setLetterValue(tiles.getLetterValue() - 1);
                break;
            }
        }
    }
    //Whenever Player takes tiles out, reduce the tile count from the array


    public char[] assignToFrame() {
        char[] returnArray = new char[7];
        for (int i = 0; i < 7; i++) {
            int random = (int) (Math.random() * numberOfTilesInPool.size());
            Tiles linkedTile = numberOfTilesInPool.get(random);
            tileLimit(linkedTile);
            returnArray[i] = linkedTile.getLetter();
            reduceTileCount(linkedTile.getLetter());
        }
        return returnArray;
    }
    //the frame class should be able to call this from its class

    public LinkedList<Tiles> getNumberOfTilesInPool() {
        return numberOfTilesInPool;
    }
    //display the tiles in the bag

    public String toString(){
        StringBuilder i = new StringBuilder();
        for(Tiles tiles : numberOfTilesInPool){
            i.append(tiles.getLetter()).append(" has ").append(tiles.getLetterValue()).append(" tiles in the bag").append("\n");
        }
        return i.toString();
    }

    public static void main(String[] args) {
        Pool i = new Pool();
        System.out.println(i);

    }


}
