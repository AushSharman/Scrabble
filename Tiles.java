
//Ayush Sharma .

public class Tiles 
{
	private char letter;
    private int letterPoints;    //Points Of Tiles
    private static final int[] LETTERPOINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0};  //Tile Points

//Tiles is now only just the letter itself and its corresponding Points - not the letter and its occurances

    public Tiles(char letter){
        this.letter = Character.toUpperCase(letter);
        if (letter == '_') {
            this.letter = letter;
            letterPoints = 0;
        }
        else {
            letterPoints = LETTERPOINTS[letter - 'A'];
        }
    }

    /*The constructor takes in i.)the letter itself and ii.)the points of letters there are*/

    public static int[] getLettervalueArray(){
        return LETTERPOINTS;
    }

    public char getLetter(){
        return (char)letter;
    }


    public int getLetterPoints(){
        return letterPoints;
    }

    public boolean equals(Tiles tiles){
        return this.getLetter() == tiles.getLetter();
    }


}
