
import java.util.Arrays;
import java.util.Scanner;

// S-u-z    -> Suzanne Byrne -> 18321676

public class Frame {
    private char[] frame;
//    private Tiles tiles; - need further information
//    private Player player;

    public Frame() {
        frame = new char[7];
        Pool.drawTiles(this, 7);
    }


    //frame getters and setters
    public char[] getFrame() {
        return frame;
    }


    //function to check if frame is empty
    public boolean IsFrameEmpty() {
        for (char c : frame) {
            if (c != 0) return false;
        }
        System.out.println("Player frame is empty");
        return true;
    }


    //swap function, swaps select number of tiles from the pool function
//    public  void swap(Frame frame, int NumberOfLetter) {
//        pool.swap(frame, NumberOfLetter);
//    }

    public void removeTile(char letter) { //Removes the Tile from the Frame
        for (int tiles = 0; tiles < 7; tiles++) {
            if (frame[tiles] == letter) {
                frame[tiles] = 0;
            }
        }
    }

    public boolean hasFrameTile(char letter) {       //Checks if the Frame has the Tile
        for (char c : frame) {
            if (c == letter) return true;
        }
        return false;
    }


    //reset function, empties the frame
    public void reset(char[] frameDisplay) {
        Arrays.fill(frame, ' ');
        //prints the now empty frame
        for (char c : frame) {
            System.out.print("[" + c + "]");
        }

    }

    //returns the frame as a string
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (char letter : frame) {
            sb.append(letter).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    // TODO: 11/03/2020 Should I connect Tiles and Frame
}
