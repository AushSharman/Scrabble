
//Ayush Sharma .

public class Tiles 
{
	private char letter;
    private int letterValue;    //Number Of Tiles
    private static final int[] LETTERVALUE = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0};  //Tile Points


    public Tiles(){

    }
    public Tiles(char letter, int letterValue){
        this.letter = letter;
        this.letterValue = letterValue;
    }

    public int[] getLettervalueArray(){
        return LETTERVALUE;
    }

    public char getLetter(){
        return (char)letter;
    }


    public int getLetterValue(){
        return letterValue;
    }

    public void setLetterValue(int value){
        letterValue = value;
    }
}
