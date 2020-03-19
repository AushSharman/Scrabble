import java.util.Scanner;

public class Board {
    //instance variables :
    private static Tiles[][] board;
    private static boolean first = true;
    private static boolean firstPlacement = true;
    private int wordPlacement;
    private static final char[] SIGNS = {'*', '£', '@', '+'};


    //Constructor :
    public Board() {
        board = new Tiles[15][15];   //Board of 15x15
    }


    //Board Design Method :
    public void display() {
        System.out.println("-------------------------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int column = 0; column < board.length; column++) {
//                if (row == 7 && column == 7) System.out.print('!' + "|");
                if (board[row][column] == null) System.out.print(' ');
                else if (board[row][column] != null) System.out.print(board[row][column].getLetter());
                System.out.print('|');
            }
            System.out.println();
            System.out.println("-------------------------------");
        }
    }

  /*  public static void multipliers(int row, int column) {
        //Triple Word Score
        if ((row == 0 && column == 0 || row == 0 && column == 7 || row == 0 && column == 14 ||
            row == 7 && column == 0 || row == 7 && column == 14 ||
            row == 14 && column == 0 || row == 14 && column == 7 || row == 14 && column == 14)) {
            board[row][column] = SIGNS[0];
        }
        //Double Word Score
        else if ((row == 1 && column == 1 || row == 1 && column == 13 || row == 2 && column == 2 || row == 2 && column == 12 ||
            row == 3 && column == 3 || row == 3 && column == 11 || row == 4 && column == 4 || row == 4 && column == 10 ||
            row == 10 && column == 4 || row == 10 && column == 10 || row == 11 && column == 3 || row == 11 && column == 11 ||
            row == 12 && column == 2 || row == 12 && column == 12 || row == 13 && column == 1 || row == 13 && column == 13)){
            board[row][column] = SIGNS[1];
        }
        //Centre
        else if (row == 7 && column == 7) {
            board[row][column] = '!';
        }
        //Triple Letter Score
        else if ((row == 1 && column == 5 || row == 1 && column == 9 || row == 5 && column == 1 ||
                row == 5 && column == 5 || row == 5 && column == 9 || row == 5 && column == 13 ||
                row == 9 && column == 1 || row == 9 && column == 5 || row == 9 && column == 9 ||
                row == 9 && column == 13 || row == 13 && column == 5 || row == 13 && column == 9)){
            board[row][column] = SIGNS[2];
        }
        //Double Letter Score
        else if ((row == 0 && column == 3 || row == 0 && column == 11 || row == 2 && column == 6 ||
                row == 2 && column == 8 || row == 3 && column == 0 || row == 3 && column == 7 ||
                row == 3 && column == 14 || row == 6 && column == 2 || row == 6 && column == 6 ||
                row == 6 && column == 8 || row == 6 && column == 12 || row == 7 && column == 3 ||
                row == 7 && column == 11 || row == 8 && column == 2 || row == 8 && column == 6 ||
                row == 8 && column == 8 || row == 8 && column == 12 || row == 11 && column == 0 ||
                row == 11 && column == 7 || row == 11 && column == 14 || row == 12 && column == 6 ||
                row == 12 && column == 8 || row == 14 && column == 3 || row == 14 && column == 11)) {
            board[row][column] = SIGNS[3];
        }
    }

    public static int getMultiplierValueOnBoard(int row, int col) {
        char multiplier = getBoardTile(row, col);
        if (multiplier == SIGNS[1] || multiplier == SIGNS[3]) return 2;
        else if (multiplier == SIGNS[0] || multiplier == SIGNS[2]) return 3;
        else return 1;
    }   */


    public static Tiles getBoardTile(int row, int col) {
        return board[row][col];
    }

    public void setHorizontalTiles(Scanner input, int wordSize, int row, int col, Player player) {
//        System.out.println("word is going to place horizontally. word count is : " + wordSize);
        for (int i = 0; i < wordSize; i++) {
//            System.out.println("i in hori " + i);
            System.out.println("Enter tiles : ");
            char tile = input.next().charAt(0);
            if (firstPlacement) {
                if (isOccupied(row, col, wordSize, 1) || canOverwriteTile(row, col, new Tiles(tile))) {
                    if (player.getFrame().hasFrameTile(tile)) {  //Checks if the Frame has the required Tile to place it
                        player.getFrame().removeTile(tile);     //Removes the Tile from the PlayerFrame - Works perfect upto here
                        //And adds that tile back to Pool
                        board[row][col] = new Tiles(tile);
                        col++;
                    } else {
                        System.out.println("The tile you have chosen " + "[" + tile + "] does not exist - Choose again");
                        setHorizontalTiles(input, wordSize - i, row, col, player);
                        return;
                    }
                } else {
                    System.out.println("The position chosen is occuipied with the letter - " + getBoardTile(row, col) + "- Try again");
                    setTiles(input, wordSize, wordPlacement, player);
                    return;
                }
                firstPlacement = false;
            } else{
                if ((isOccupied(row, col, wordSize, 1) || canOverwriteTile(row, col, new Tiles(tile)))){ //&& isConnecting()) {
                    if (player.getFrame().hasFrameTile(tile)) {  //Checks if the Frame has the required Tile to place it
                        player.getFrame().removeTile(tile);     //Removes the Tile from the PlayerFrame - Works perfect upto here
                        //And adds that tile back to Pool
                        board[row][col] = new Tiles(tile);
                        col++;
                    } else {
                        System.out.println("The tile you have chosen " + "[" + tile + "] does not exist - Choose again");
                        setHorizontalTiles(input, wordSize - i, row, col, player);
                        return;
                    }
                } else {
                    System.out.println("The position chosen is occuipied with the letter - " + getBoardTile(row, col) + "- Try again");
                    setTiles(input, wordSize, wordPlacement, player);
                }
            }
        }
        player.getFrame().refill();
    }

    public void setVerticalTiles(Scanner input, int wordSize, int row, int col, Player player) {
//        System.out.println("word is going to place vertically. word count is : " + wordSize);
        for (int j = 0; j < wordSize; j++) {
            System.out.println("Enter tiles : ");
            char tile = input.next().charAt(0);
            if (firstPlacement) {
                if (isOccupied(row, col, wordSize, 2) || canOverwriteTile(row, col, new Tiles(tile))) { //If tilePos is occupied - ask for Positions again
                    if (player.getFrame().hasFrameTile(tile)) {
                        player.getFrame().removeTile(tile);
                        board[row][col] = new Tiles(tile);
                        row++;
                    } else {
                        System.out.println("The tile you have chosen " + "[" + tile + "] does not exist - Choose again");
                        setVerticalTiles(input, wordSize - j, row, col, player);
                        return;
                    }
                } else {
                    System.out.println("The position chosen is occuipied with the letter - " + getBoardTile(row, col) + "- Try again");
                    setTiles(input, wordSize, wordPlacement, player);
                    return;
                }
                firstPlacement = false;
            } else{
                if ((isOccupied(row, col, wordSize, 2) || canOverwriteTile(row, col, new Tiles(tile))) ){//&& isConnecting()) { //If tilePos is occupied - ask for Positions again
                    if (player.getFrame().hasFrameTile(tile)) {
                        player.getFrame().removeTile(tile);
                        board[row][col] = new Tiles(tile);
                        row++;
                    } else {
                        System.out.println("The tile you have chosen " + "[" + tile + "] does not exist - Choose again");
                        setVerticalTiles(input, wordSize - j, row, col, player);
                        return;
                    }
                } else {
                    System.out.println("The position chosen is occuipied with the letter - " + getBoardTile(row, col) + "- Try again");
                    setTiles(input, wordSize, wordPlacement, player);
                    return;
                }
            }

        }
        player.getFrame().refill();
    }

    public boolean isOccupied(int row, int col, int wordSize, int placement) {
        if (placement == 1) {   //The tile placement is Horizontal
            for (int i = 0; i < wordSize; i++) {
                if (board[row][col] != null) return false;
                col++;
            }
            return true;
        } else if (placement == 2) {     //The tile placement is Vertical
            for (int i = 0; i < wordSize; i++) {
                if (board[row][col] != null) return false;
                row++;
            }
        }
        return true;
    }

    public boolean canOverwriteTile(int row, int col, Tiles tiles) {
        return board[row][col].equals(tiles);
    }

    /*public boolean isConnecting(int row, int col){//If vertical of horizontal placement - check in a sqaure
        if (row== 0 && col == 0) //check right and down
        if (row == 0 && col == 14)//check left and down
        if (row == 0) //check left,right and down

        if (col == 0 && row == 14)//Check up and right
         if (col == 0) //check the right up and down

        if (row == 14 && col == 14)//Check left & up
        if (row == 14)//Check up and left and right

        if (col == 14)//Check left and up and down
    }*/
    //Conditions for if the location is on the edge of the board





    private boolean isTileInBound(int row, int col, int vertical, int lengthOfWord) {
        if (first) {  //if first call to this Method -> TIles must cover the center
            if (row > 15 || col > 15 || row < 0 || col < 0) {
                if (vertical == 1 && firstTileH(row, col, lengthOfWord)) {
                    first = false;
                    return true;
                } else if (vertical == 2 && firstTileV(row, col, lengthOfWord)) {
                    first = false;
                    return true;
                } else {
                    System.out.println("Your tiles must cover the center squares [8,8] - Try again");
                    return false;
//                getBoardInput(player);
                }
            } else {
                System.out.println("Co-ordinates chosen are out of bounds - Try again");
                return false;
            }
        }else {
            if (vertical == 1 && col + lengthOfWord > 15) {
                System.out.println("\"Your placement of the Tiles are out of bounds[15x15] - Try again\"");
                return false;
//                getBoardInput(player);
            } else if (vertical == 2 && row + lengthOfWord > 15) {
                System.out.println("incorrect");
                return false;
//                getBoardInput(player);
            }
            return true;
        }
    }

    public boolean firstTileH(int row, int col, int wordSize) {  //Row stays the same - Column changes - Just Checks
        for (int i = 0; i < wordSize; i++) {  //Checks that whatever the length of the word you wish to place will actually cover the centre piece
            if (row == 7 && col == 7) {
                return true;
            }
            col++;
        }
        return false;
        //        getBoardInput();
    }

    public boolean firstTileV(int row, int col, int wordSize) {  //Just Checks
        for (int i = 0; i < wordSize; i++) {  //Checks that whatever the length of the word you want to place will actually cover the centre piece
            if (row== 7 && col== 7) {
                return true;
            }
            row++;
        }
        return false;
    }

    public String[] getNewPositions(){
        int row, column = 0;
        System.out.println("Enter the position[row, col] on the board : ");
        Scanner in = new Scanner(System.in);
        String[] res = in.next().split(",");
        return res;
    }

    public void setTiles(Scanner input,int wordSize, int placementFormat, Player player){
        String[] in = getNewPositions();
        int row = Integer.parseInt(in[0]) - 1;
        int col = Integer.parseInt(in[1]) - 1;
        if (!isTileInBound(row, col, placementFormat, wordSize)) {
//            System.out.println("The position entered [" + row + "," + col + "] is invalid - Try again");
            getBoardInput(player);
            return;
        }
        if (placementFormat == 1) setHorizontalTiles(input, wordSize, row, col, player);
        else if (placementFormat == 2) setVerticalTiles(input, wordSize, row, col, player);
    }
    //Method asks for [row,col] and checks if it is in bounds
    //IF yes - Allow placement of the TIles

    //Getting tile input from user
    public void getBoardInput(Player player) {
        int wordSize,row, col = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Select [1]-place word horizontally or select [2]-place word vertically : ");
        wordPlacement = input.nextInt();
        System.out.println("Enter word size : ");
        wordSize = input.nextInt();
        setTiles(input, wordSize,wordPlacement, player);

    }

    //Board Reset :
    public void reset() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = null;

            }
        }
    }

    //Check that the tile placement is within the bounds of the board
    public static void main(String[] args) {
        Pool pool = new Pool();
//        System.out.println(pool);
        System.out.println(Pool.getTotalTiles());
        Player player = new Player("John");
        Board board = new Board();
        board.display();
        System.out.println(player.getFrame());
        board.getBoardInput(player);
        board.display();
        System.out.println(player.getFrame());
        System.out.println(Pool.getTotalTiles());
        board.getBoardInput(player);
        board.display();
    }
}
