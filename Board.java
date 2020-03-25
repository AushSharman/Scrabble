import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {
    //instance variables :
    private static Tiles[][] board;
    public static ArrayList<Integer> pos;
    private static boolean first = true;
    private static boolean firstPlacement = true;
    private int wordPlacement;
    private static final char[] SIGNS = {'*', '£', '@', '+'};


    //Constructor :
    public Board() {
        board = new Tiles[15][15];
        pos = new ArrayList<Integer>();
        //Board of 15x15
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

    public static char getMultipliers(int row, int column) {
        //Triple Word Score
        if ((row == 0 && column == 0 || row == 0 && column == 7 || row == 0 && column == 14 ||
            row == 7 && column == 0 || row == 7 && column == 14 ||
            row == 14 && column == 0 || row == 14 && column == 7 || row == 14 && column == 14)) {
            return SIGNS[0];
        }
        //Double Word Score
        else if ((row == 1 && column == 1 || row == 1 && column == 13 || row == 2 && column == 2 || row == 2 && column == 12 ||
            row == 3 && column == 3 || row == 3 && column == 11 || row == 4 && column == 4 || row == 4 && column == 10 ||
            row == 10 && column == 4 || row == 10 && column == 10 || row == 11 && column == 3 || row == 11 && column == 11 ||
            row == 12 && column == 2 || row == 12 && column == 12 || row == 13 && column == 1 || row == 13 && column == 13)){
            return SIGNS[1];
        }
        //Triple Letter Score
        else if ((row == 1 && column == 5 || row == 1 && column == 9 || row == 5 && column == 1 ||
                row == 5 && column == 5 || row == 5 && column == 9 || row == 5 && column == 13 ||
                row == 9 && column == 1 || row == 9 && column == 5 || row == 9 && column == 9 ||
                row == 9 && column == 13 || row == 13 && column == 5 || row == 13 && column == 9)){
            return SIGNS[2];
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
            return SIGNS[3];
        }
        return 1;
    }

    public static Tiles getBoardTile(int row, int col) {
        return board[row][col];
    }

    public static void removeTileFromBoard(int row, int col){
        if (!isOccupied(row, col))
            board[row][col] = null;
    }

    public void calculatePoints(int wordSize, int row, int col, Player player, int placement) {
        int score = 0;
        int wordMult = 1;
        //score if calculated by adding the points of the tiles individually
        //so - if I get a double/triple letter - then - I must multiplly line 80 & 86 by 2/3 - Done
        //so - if I get a word multiplier - then I must multiply score by 2/3 - Done
        if (placement == 1) {    //Find score Horizontally
            for (int index = 0; index < wordSize; index++) {
                if (getMultipliers(row, col) == '@' || getMultipliers(row, col) == '+'){//Do Letter multipliers
                    score += (getMultipliers(row, col) == '@')? Pool.getScoreOfTile(board[row][col]) * 3 : Pool.getScoreOfTile(board[row][col]) * 2;
                }
                else if (getMultipliers(row, col) == '*' || getMultipliers(row, col) == '£'){
                    wordMult = getMultipliers(row, col) == '*'? 3 : 2;
                } else{
                    score += Pool.getScoreOfTile(board[row][col]);
                }
                col++;
            }
            player.increaseScore(score * wordMult);
        } else {
            for (int index = 0; index < wordSize; index++) {
                if (getMultipliers(row, col) == '@' || getMultipliers(row, col) == '+'){//Do Letter multipliers
                    score += (getMultipliers(row, col) == '@')? Pool.getScoreOfTile(board[row][col]) * 3 : Pool.getScoreOfTile(board[row][col]) * 2;
                }
                else if (getMultipliers(row, col) == '*' || getMultipliers(row, col) == '£'){
                    wordMult = getMultipliers(row, col) == '*'? 3 : 2;
                } else{
                    score += Pool.getScoreOfTile(board[row][col]);
                }
                row++;
            }
            System.out.println("Score is " + score);
            player.increaseScore(score * wordMult);
        }
    }

//    private boolean isConnecting(int row, int col, int wordSize, int placement){}
    public void setHorizontalTiles(Scanner input, int wordSize, int row, int col, Player player) {
        pos.clear();
        if (isTileInBound(row, col, 1,wordSize)) {
            for (int i = 0; i < wordSize; i++) {
                System.out.println("Enter tiles : ");
                char tile = input.next().charAt(0);
                if (firstPlacement) {
                    if (isOccupied(row, col) || canOverwriteTile(row, col, new Tiles(tile))) {
                        if (player.getFrame().hasFrameTile(tile)) {  //Checks if the Frame has the required Tile to place it
                            player.getFrame().removeTile(tile);     //Removes the Tile from the PlayerFrame - Works perfect upto here
                            //And adds that tile back to Pool
                            board[row][col] = new Tiles(tile);
                            pos.add(row);pos.add(col);
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
                } else {
                    if ((isOccupied(row, col) || canOverwriteTile(row, col, new Tiles(tile)))) { //&& isConnecting()) {
                        if (player.getFrame().hasFrameTile(tile)) {  //Checks if the Frame has the required Tile to place it
                            player.getFrame().removeTile(tile);     //Removes the Tile from the PlayerFrame - Works perfect upto here
                            board[row][col] = new Tiles(tile);
                            pos.add(row);pos.add(col);
                            col++;
                        } else {
                            System.out.println("The tile you have chosen " + "[" + tile + "] does not exist - Choose again");
                            setHorizontalTiles(input, wordSize - i, row, col, player);
                            return;
                        }
//                    System.out.println("Score of tile " + board[row][col].getLetter() + " is " + Pool.getScoreOfTile(board[row][col]));
                    } else {
                        System.out.println("The position chosen is occuipied with the letter - " + getBoardTile(row, col) + "- Try again");
                        setTiles(input, wordSize, wordPlacement, player);
                    }
                }
            }
        }
        calculatePoints(wordSize, row, col-wordSize, player, 1);
        player.getFrame().refill();
    }

    public void setVerticalTiles(Scanner input, int wordSize, int row, int col, Player player) {
        pos.clear();
        if (isTileInBound(row, col, 2, wordSize)) {
            for (int j = 0; j < wordSize; j++) {
                System.out.println("Enter tiles : ");
                char tile = input.next().charAt(0);
                if (firstPlacement) {
                    if (isOccupied(row, col) || canOverwriteTile(row, col, new Tiles(tile))) { //If tilePos is occupied - ask for Positions again
                        if (player.getFrame().hasFrameTile(tile)) {
                            player.getFrame().removeTile(tile);
                            board[row][col] = new Tiles(tile);
                            System.out.println("In board - tiles is " + board[row][col].getLetter());
                            pos.add(row);pos.add(col);
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
                } else {
                    if ((isOccupied(row, col) || canOverwriteTile(row, col, new Tiles(tile)))) {//&& isConnecting()) { //If tilePos is occupied - ask for Positions again
                        if (player.getFrame().hasFrameTile(tile)) {
                            player.getFrame().removeTile(tile);
                            board[row][col] = new Tiles(tile);
                            System.out.println("In board - tiles is " + board[row][col].getLetter());
                            pos.add(row);pos.add(col);
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
        }
        calculatePoints(wordSize, row-wordSize, col, player, 2);
        player.getFrame().refill();
    }

    public static boolean isOccupied(int row, int col) {
        return board[row][col] == null;
    }

    public boolean canOverwriteTile(int row, int col, Tiles tiles) {
        return board[row][col].equals(tiles);
    }


    private boolean isTileInBound(int row, int col, int vertical, int lengthOfWord) {
        if (first) {  //if first call to this Method -> TIles must cover the center
            if (row < 15 && col < 15) {
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
        } else {
            if (vertical == 1 && (row > 15 && col + lengthOfWord > 15)) {
                System.out.println("\"Your placement of the Tiles are out of bounds[15x15] - Try again\"");
                return false;
//                getBoardInput(player);
            } else if (vertical == 2 && (col > 15 && row + lengthOfWord > 15)){
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
            if (row == 7 && col == 7) {
                return true;
            }
            row++;
        }
        return false;
    }

    public String[] getNewPositions() {
        int row, column = 0;
        System.out.println("Enter the position[row, col] on the board : ");
        Scanner in = new Scanner(System.in);
        String[] res = in.next().split(",");
        return res;
    }

    public void setTiles(Scanner input, int wordSize, int placementFormat, Player player) {
        String[] in = getNewPositions();
        int row = Integer.parseInt(in[0]) - 1;
        int col = Integer.parseInt(in[1]) - 1;
        if (!isTileInBound(row, col, placementFormat, wordSize)) {
            getBoardInput(player);
            return;
        }
        if (placementFormat == 1) {
            setHorizontalTiles(input, wordSize, row, col, player);
        } else if (placementFormat == 2) {
            setVerticalTiles(input, wordSize, row, col, player);
        }
    }


    //Getting tile input from user
    public void getBoardInput(Player player) {
        int wordSize, row, col = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Select [1]-place word horizontally or select [2]-place word vertically : ");
        wordPlacement = input.nextInt();
        System.out.println("Enter word size : ");
        wordSize = input.nextInt();
        setTiles(input, wordSize, wordPlacement, player);

    }

    //Board Reset :
    public void reset() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = null;

            }
        }
    }


}
