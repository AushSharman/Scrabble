
import java.util.Arrays;
import java.util.Scanner;

// S-u-z    -> Suzanne Byrne -> 18321676

public class Frame 
{
    private char [] frame;
    //frame constructor
    public Frame() {
        frame = new char[7];
        Pool.drawTiles(frame, 7);

    }

    //frame getters and setters
    public char[] getFrame() {
        return frame;
    }

    public void setFrame(char[] frame) {
        this.frame = frame;
    }

    //function to check if frame is empty
    public boolean IsFrameEmpty() {
        for (int frameIndex = 0; frameIndex < frame.length; frameIndex++){
            if(frame[frameIndex] != 0) return false;
        }
        System.out.println("Player frame is empty");
        return true;
    }

    //function to display frame
    public void display() {

    }

    //swap function, swaps select number of tiles from the pool function
//    public  void swap(Frame frame, int NumberOfLetter) {
//        pool.swap(frame, NumberOfLetter);
//    }

    public void removeTile(char letter){
        for (int tiles = 0; tiles < 7; tiles++){
            if (frame[tiles] == letter){
                frame[tiles] = 0;
            }
        }
    }

    public boolean hasFrameTile(char letter){       //Checks if the Frame has the Tile
        for (int i = 0; i < frame.length; i++){
            if (frame[i] == letter) return true;
        }
        return false;
    }



    //reset function, empties the frame
    public  void reset(char[] frameDisplay) {

        Arrays.fill(frame, ' ');

        //prints the now empty frame
        for(int i = 0; i < frame.length; i++) {
            System.out.print("[" + frame[i] + "]");
        }

    }

    //returns the frame as a string
    public String toString(){
        String res = "";
        for(char letter : frame){
            res += letter + " ";
        }
        return res;
    }
}
