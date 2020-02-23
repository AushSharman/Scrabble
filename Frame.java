
import java.util.Arrays;
import java.util.Scanner;

// S-u-z    -> Suzanne Byrne -> 18321676

public class Frame 
{
	private Pool pool = new Pool();;
    private static char [] frame;
    //frame constructor
    public Frame() {
        frame = new char[7];
        frame = pool.assignToFrame();

    }

    //frame getters and setters
    public char[] getFrame() {
        return frame;
    }

    public void setFrame(char[] frame) {
        this.frame = frame;
    }

    //function to check if frame is empty
    public  boolean IsFrameEmpty() {

        if(frame == null) {
            System.out.println("Frame is Empty");
            return false;
        }
        else {
            return true;
        }
    }

    //function to display frame
    public  void Display() {

        //if frame is empty, access the pool
        if(IsFrameEmpty() == false) {
        	
            System.out.println("Frame is not full! Access the Pool.");
        }
        
        else {
          //else if frame has at least 1 tile, check amount
          System.out.println("Frame has: "+ frame.length + " tile(s)");
        }

        
        //frame should never be over 7, exception
        if(frame.length > 7) {
            throw new RuntimeException("Frame is too big!");
        }

        //if frame is full
        if(frame.length == 7) {
            System.out.println("Frame: ");

            //prints all tiles
            for(int i = 0; i < frame.length; i++) {
                System.out.print("[" + frame[i] + "]");
            }

            //whitespace
            System.out.print("\n");

            //asks for user input to either swap reset or commence the game
            //requires user to input an int value 
            System.out.println("Do you want to swap (1)/ reset tiles (2) or play game (3)?");
            
            //scans users input
            Scanner r = new Scanner(System.in);
            int removal = r.nextInt();

            //if the input is 1, swap function is called
            if(removal == 1) {
                System.out.println("you may remove tiles, select tile number");

                //scans users input for an int value
                //the int value represents the number of tiles to be swapped
                Scanner s = new Scanner(System.in);
                int swap = s.nextInt();

            }
            //else if the input is 2, reset function is called
            else if(removal == 2) {
                System.out.println("you may reset tiles");
                reset(frame);
            }
            //else if the input is 3, resume game play
            else if(removal == 3) {
                System.out.println("play game!");
            }

        }

    }

    //swap function, swaps select number of tiles from the pool function
    public  void swap(Frame frame, int NumberOfLetter) {

        pool.swap(frame, NumberOfLetter);
    }

    public static void removeTile(char letter){
        for (int tiles = 0; tiles < frame.length; tiles++){
            if (frame[tiles] == letter){
                frame[tiles] = 0;
            }
        }
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
