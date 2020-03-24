
//GrandNeedleWorker - ayush sharma - 18301681

import java.util.*;

public class Pool {
    private static LinkedList<Tiles> numberOfTilesInPool;
    private static int[] letterCount = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};    //Number OF tiles


    public Pool() {
        numberOfTilesInPool = new LinkedList<Tiles>();
        char[] tiles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" .toCharArray();
        for (int j = 0; j < tiles.length; j++) {
            numberOfTilesInPool.add(new Tiles(tiles[j]));
        }
    }

    public static int getScoreOfTile(Tiles tiles) {
        return tiles.getLetterPoints();
    }
    //Allow access to the points of a tile

    public static int getWordScore(String word) {
        int sum = 0;
        for (char letter : word.toCharArray()) {
            sum += getScoreOfTile(new Tiles(Character.toUpperCase(letter)));
        }
        return sum;
    }
    //Get score of the word itself


    public static boolean tileLimit(Tiles tiles){
        if (tiles.getLetter() == '_') return letterCount[letterCount.length - 1] <= 0;
        return letterCount[tiles.getLetter() - 'A'] <= 0;
    }

    public static void setLetterCount(char letter, int val){    //Takes in the the letter you want setted, and it's corresponding value
                //and sets the letter to that value. i.e - sLC(A, 2) -> The number of occurracnes of A is now 2
        if (letter == '_') letterCount[letterCount.length - 1] = val;
        else {
            letterCount[letter - 'A'] = val;
        }
    }

    public static int getLetterCount(char letter){      //Returns the number of occurrances that the letter has
        if (letter == '_') return letterCount[letterCount.length-1];
        return letterCount[letter - 'A'];
    }

    //Returns the number of tiles in the pool at the moment

    public void resetPool() {
        Arrays.fill(letterCount, 0);
    }
    //Set all the values of the Tiles to be 0


    public static boolean isPoolEmpty() {
        return getTotalTiles() == 0;
    }

    public static void addTileBack(Tiles tiles) {   //Increase the Number of tileCount
//        System.out.println("In addBack");
//        System.out.println("The tile before " + tiles.getLetter() + " is now " + (int)getLetterCount(tiles.getLetter()));
        setLetterCount(tiles.getLetter(), ((int)getLetterCount(tiles.getLetter()) + 1));
//        System.out.println("The tile after " + tiles.getLetter() + " is now " + getLetterCount(tiles.getLetter()));
    }



    public static void reduceTileCount(Tiles tile) { //Reduce the Number of tileCount of a tile in the LinkedList -
        setLetterCount(tile.getLetter(), getLetterCount(tile.getLetter())-1);
    }


    //Get the indexes with the Frame[] is 0 - and overwrite
    public static void drawTiles(Frame frame, int numberOfTilesWantToDraw) {
//        System.out.println("Before drawing - " + getTotalTiles());
        for (int index = 0; index < numberOfTilesWantToDraw; index++) {
//            System.out.println("Index is " + index);
            if (frame.getFrame()[index] != null) continue;
            int random = (int) (Math.random() * numberOfTilesInPool.size());    //RandomIndex
            Tiles randomTile = numberOfTilesInPool.get(random);                 //Random Tile Object
//            System.out.println("In drawTie");
//            System.out.println("Tile is drawTile is " + randomTile.getLetter() + " is " + getLetterCount(randomTile.getLetter()));
            if (!tileLimit(randomTile)){
                frame.getFrame()[index] = randomTile; //Gets a random letter from the LL - and pops it into the player frame
                reduceTileCount(randomTile);
//                System.out.println("Random Tile after reduction "+ getLetterCount(randomTile.getLetter()));
            }
            else{
//                System.out.println("The tile chosen :"+randomTile.getLetter()+" is empty ");
                drawTiles(frame, numberOfTilesWantToDraw);
                return;//If Tile is empty - pick another tile
//                System.out.println("Inside drawTiles v2");
            }
//            System.out.println("After drawing - " + getTotalTiles());
        }
//        System.out.println("After drawTile");
    }

    public static int getTotalTiles(){
        int sum = 0;
        for (int numOfOccur : letterCount){
            sum += numOfOccur;
        }
        return sum;
    }

    public static LinkedList<Tiles> getNumberOfTilesInPool() {
        return numberOfTilesInPool;
    }

    public String toString() {
        String result = "";
        for (Tiles tiles : numberOfTilesInPool) {
//            if (tiles == null) return "Pool is empty";
            result += tiles.getLetter() + " has " + getLetterCount(tiles.getLetter()) + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        System.out.println(Pool.getTotalTiles()+ " - number of Total Tiles");
        System.out.println(pool);
        Player player = new Player("JOn");
        Player player1 = new Player("Jack");
        System.out.println(player.getFrame());
        System.out.println(player1.getFrame());
        System.out.println(Arrays.toString(letterCount));
        System.out.println(Pool.getWordScore("cabbage"));
        System.out.println(Pool.getTotalTiles());

        pool.resetPool();
        System.out.println(pool);
    }


}
