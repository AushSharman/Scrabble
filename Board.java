import java.util.Scanner;

public class Board {
    //instance variables :
    private static char[][] board;
    private static boolean checked = true;
    private static  boolean first = true;
    private static Frame frame;

    //Constructor :
    public Board() {
        board = new char[15][15];
        frame = new Frame();
    }

    //Board Design Method :
    public void boardDisplay() {
        System.out.println("-------------------------------");

        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int column = 0; column < board.length; column++) {
                boardValue(row, column);
                System.out.print(board[row][column] + "|");
            }
            System.out.println();
            System.out.println("-------------------------------");
        }
    }

    public void boardValue(int row, int column) {
        //Triple Word Score
        if ((row == 0 && column == 0 || row == 0 && column == 7 || row == 0 && column == 14 || row == 7 && column == 0 || row == 7 && column == 14 || row == 14 && column == 0 || row == 14 && column == 7 || row == 14 && column == 14) && board[row][column] == 0) {
            board[row][column] = '*';
        }
        //Double Word Score
        else if ((row == 1 && column == 1 || row == 1 && column == 13 || row == 2 && column == 2 || row == 2 && column == 12 || row == 3 && column == 3 || row == 3 && column == 11 || row == 4 && column == 4 || row == 4 && column == 10 || row == 10 && column == 4 || row == 10 && column == 10 || row == 11 && column == 3 || row == 11 && column == 11 || row == 12 && column == 2 || row == 12 && column == 12 || row == 13 && column == 1 || row == 13 && column == 13) && board[row][column] == 0) {
            board[row][column] = ' ';
        }
        //Centre
        else if ((row == 7 && column == 7) && board[row][column] == 0) {
            board[row][column] = '!';
        }
        //Triple Letter Score
        else if ((row == 1 && column == 5 || row == 1 && column == 9 || row == 5 && column == 1 || row == 5 && column == 5 || row == 5 && column == 9 || row == 5 && column == 13 || row == 9 && column == 1 || row == 9 && column == 5 || row == 9 && column == 9 || row == 9 && column == 13 || row == 13 && column == 5 || row == 13 && column == 9) && board[row][column] == 0) {
            board[row][column] = '@';
        }
        //Double Letter Score
        else if ((row == 0 && column == 3 || row == 0 && column == 11 || row == 2 && column == 6 || row == 2 && column == 8 || row == 3 && column == 0 || row == 3 && column == 7 || row == 3 && column == 14 || row == 6 && column == 2 || row == 6 && column == 6 || row == 6 && column == 8 || row == 6 && column == 12 || row == 7 && column == 3 || row == 7 && column == 11 || row == 8 && column == 2 || row == 8 && column == 6 || row == 8 && column == 8 || row == 8 && column == 12 || row == 11 && column == 0 || row == 11 && column == 7 || row == 11 && column == 14 || row == 12 && column == 6 || row == 12 && column == 8 || row == 14 && column == 3 || row == 14 && column == 11) && board[row][column] == 0) {
            board[row][column] = '+';
        }
    }


    public void setHorizontalTiles(Scanner input, int wordSize, int row, int col) {
        while (checked) {
            firstTileH(row, col, wordSize);
            checked = false;
        }
        for (int i = 0; i < wordSize; i++) {
            System.out.println("Enter tiles : ");
            char tile = input.next().charAt(0);
            if (hasFrameTile(tile)) {
                frame.removeTile(tile);
                if (first) {
                    board[row - 1][col - 1] = tile;
                } else {
                    canOverWrite(row - 1, col - 1, tile);
                    if (checkingSpacesH(row - 1, col - 1, wordSize)) {
                        board[row - 1][col - 1] = tile;
                    }
                }
                col++;
            }
            else{
                        throw new IllegalArgumentException("Cannot place tile as you dont have it");
                    }
                }
            }

    public void setVerticalTiles(Scanner input, int wordSize, int row, int col) {
        while (checked) {
            firstTileV(row, col, wordSize); //Check to see if it is the centre piece
            checked = false;
        }
        for (int j = 0; j < wordSize; j++) {
            System.out.println("Enter tiles : ");
            char tile = input.next().charAt(0);
            if (hasFrameTile(tile)) {
                frame.removeTile(tile);
                if (first) {
                    board[row - 1][col - 1] = tile;
                } else {
                    canOverWrite(row - 1, col - 1, tile);
                    if (checkingSpacesV(row - 1, col - 1, wordSize)) {
                        board[row - 1][col - 1] = tile;
                    }
                }
                row++;
            } else{
                throw new IllegalArgumentException("Cannot place tile as it is not in the Frmae");
            }
        }
        }

        public boolean hasFrameTile(char letter){   //Checks if the player frame has the tile
            for (char tile : frame.getFrame()){
                if (Character.toUpperCase(letter) == tile){
                    return true;
                }
            }
            return false;
        }

    private boolean checkingSpacesV(int row, int col, int wordSize){  //Checks to see that if the tiles around the position aren't Letters - if so, then that means it isnt connected to any word and so throw an excpetion
        boolean var = true;
        for (int i = 0; i < wordSize; i++) {
            if (!Character.isAlphabetic(board[row][col + 1]) && !Character.isAlphabetic(board[row + 1][col]) && !Character.isAlphabetic(board[row + 1][col + 1]) && !Character.isAlphabetic(board[row - 1][col]) && !Character.isAlphabetic(board[row + 1][col - 1]) && !Character.isAlphabetic(board[row][col - 1])) {
                var = false;
            }
            row++;
        }
        return var;
    }

    private boolean checkingSpacesH(int row, int col, int wordSize){  //Checks to see that if the tiles around the position aren't Letters - if so, then that means it isnt connected to any word and so throw an excpetion
        boolean var = true;
        for (int i = 0; i < wordSize; i++) {
            if (!Character.isAlphabetic(board[row][col + 1]) && !Character.isAlphabetic(board[row + 1][col]) && !Character.isAlphabetic(board[row + 1][col + 1]) && !Character.isAlphabetic(board[row - 1][col]) && !Character.isAlphabetic(board[row + 1][col - 1]) && !Character.isAlphabetic(board[row][col - 1])) {
                var = false;
            }
            col++;
        }
        return var;
    }

    public void canOverWrite(int row, int col, char tile){  //If the tile is a multiplier then you are allowed to overwrite it - provided that the tile you wish to overwrite is the same as the one you want to place
        if (board[row][col] == '!' || board[row][col] == '@' || board[row][col] == '+' || board[row][col] == '*' || board[row][col] == '=' || board[row][col] == 0 || board[row][col] == tile){
            board[row][col] = tile;
            return;
        }
        throw new IllegalArgumentException("Cannot overwrite the tile " + board[row][col] + " with the tile " + tile);
    }

    public static char getTile( int row, int col){
        return board[row-1][col-1] ;
    }


    private void isTileInBound(int row, int col) {
        if (row > 15 && col > 15 || row < 1 && col < 1 || row > 15 && col < 1 || row < 1 && col > 15) {
            throw new IllegalArgumentException("The row or (And) column cannot be greater than the length of the board - which is 15x15 ");
        }
    }

    //Getting tile input from user onto board :
    public void getBoardInput() throws IllegalArgumentException {
        int wordSize, row, column = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Select 1 to place word horizontally or select 2 to place word vertically : ");
        int result = input.nextInt();

        System.out.println("Enter word size : ");
        wordSize = input.nextInt();
        System.out.println("Enter row position on board : ");
        row = input.nextInt();
        System.out.println("Enter column position on board : ");
        column = input.nextInt();
        isTileInBound(row-1, column-1);
        if ((result == 1)) {
                setHorizontalTiles(input, wordSize, row, column);
        }
            else {
                setVerticalTiles(input, wordSize, row, column);
            }
        first = false;
    }


    public static void firstTileH(int row, int col, int wordSize) {  //Row stays the same - Column changes - Just Checks
        for(int i = 0; i < wordSize; i++){  //Checks that whatever the length of the word you wish to place will actually cover the centre piece
            if (row-1 == 7 && col-1 == 7){
                return;
            }
            col++;
        }
        throw new IllegalArgumentException("You must place tiles that cover the centre tile - [8,8]");
    }

    public static void firstTileV(int row, int col, int wordSize){  //Just Checks
        for(int i = 0; i < wordSize; i++){  //Checks that whatever the length of the word you want to place will actually cover the centre piece
            if (row-1 == 7 && col-1 == 7){
                return;
            }
            row++;
        }
        throw new IllegalArgumentException("You must place tiles that cover the centre tile - [8,8]");
    }


    //Board Reset :
    public void boardReset() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = 0;

            }
        }
    }

    //Check that the tile placement is within the bounds of the board
    public static void main(String[] args) {
        Board board = new Board();
        Frame f = new Frame();
        System.out.println(f);
        for(int i = 0; i < 2; i++) {
            board.getBoardInput();
        }
        board.boardDisplay();
        System.out.println(getTile(8, 8));
        //System.out.println(getTile(board, 8, 8));
    }


  } //FML