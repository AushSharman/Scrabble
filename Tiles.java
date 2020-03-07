
//Ayush Sharma .

public class Tiles 
{
	private char letter;
    private int letterCount;    //Number Of Tiles
    private static final int[] LETTERPOINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0};  //Tile Points


    public Tiles(){}

    public Tiles(char letter, int letterValue){
        this.letter = Character.toUpperCase(letter);
        letterCount = letterValue;
    }

    /*The constructor takes in i.)the letter itself and ii.)the #of letters there are*/

    public static int[] getLettervalueArray(){
        return LETTERPOINTS;
    }

    public char getLetter(){
        return (char)letter;
    }


    public int getLetterCount(){
        return letterCount;
    }

    public static void setLetterCount(Tiles tiles, int val){
        tiles.letterCount = val;
    }

    public static boolean tileLimit(Tiles tile){
        return tile.getLetterCount() <= 0;
    }

}
