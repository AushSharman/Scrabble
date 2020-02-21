import java.util.Scanner;

public class Board {
    //instance variables :
    private char[][] board;
    private Frame frame;
    private static boolean checked = true;

    //Constructor :
    public Board() {
        this.board = new char[15][15];
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
        else if ((row == 7 && column == 7) && board[row][column] == ' ') {
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

	/*public boolean isTileOnFrame(char tile){
		for (char tiles : frame.getFrame()){
			if (tiles == tile){
				return true;
			}
		}
		throw new IllegalArgumentException("You do not have the tile needed to place on the Board");
	}*/

    public void setHorizontalTiles(Scanner input, int wordSize, int row, int col) {
        while (checked) {
            firstTile(row, col);
            checked = false;
        }
        for (int i = 0; i < wordSize; i++) {
            System.out.println("Enter tiles : ");
            char tile = input.next().charAt(0);
			/*if (isTileOnFrame(tile)){
				frame.removeTile(tile);
			}*/
            board[row - 1][col - 1] = tile;
            col++;
        }
    }

    public void setVerticalTiles(Scanner input, int wordSize, int row, int col) {
        while (checked) {
            firstTile(row, col);
            checked = false;
        }
        for (int j = 0; j < wordSize; j++) {
            System.out.println("Enter tiles : ");
            char tile = input.next().charAt(0);
			/*if (isTileOnFrame(tile)){
				frame.removeTile(tile);
			}*/
            board[row - 1][col - 1] = tile;
            row++;
        }
    }

    private void isTileInBound(int row, int col) {
        if (row > 15 || col > 15) {
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
        } else {
            setVerticalTiles(input, wordSize, row, column);
        }
    }

    //TEST : ** TEMPORARY METHOD **
    //Displaying tile on a given position .
    public void tilePositionTestMethod() {
        System.out.print("Current tile on position 7 7 : ");
        System.out.println(board[7][7]);
        System.out.print("Current tile on position 5 7 : ");
        System.out.println(board[5][7]);
    }

    private void firstTile(int row, int col) {
        if (row != 7 && col != 7) {
            throw new IllegalArgumentException("Cannot place Tile at any other place besides the Centre");
        }
    }

    //Board Reset :
    public void boardReset() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = ' ';

            }
        }
    }

    //Check that the tile placement is within the bounds of the board
    public static void main(String[] args) {
        Board board = new Board();
        for (int i = 0; i < 2; i++){
        	board.getBoardInput();
		}
        //board.boardDisplay();
        board.tilePositionTestMethod();
    }

    // TODO: 20/02/2020 Check that the frame has the nessacary letters to place the tiles on the Board - Need to Test
    // TODO: 20/02/2020 The tile placement is within the bounds of the board - Need to Test
    // TODO: 20/02/2020 If the tile placed is on a multiplier then, overwrite the multiplier
}
