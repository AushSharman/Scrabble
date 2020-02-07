import java.util.Arrays;
import java.util.Scanner;

public class Frame {

    private Pool pool = new Pool();;
    private char [] frame;



    public Frame() {
        frame = new char[7];
        frame = pool.assignToFrame();

    }

    public char[] getFrame() {
        return frame;
    }

    public void setFrame(char[] frame) {
        pool.reduceTiles(frame);
    }


    public  boolean IsFrameEmpty() {

        if(frame == null) {
            System.out.println("Frame is Empty");
            return false;
        }
        else {
            return true;
        }
    }


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

            System.out.print("\n");

            System.out.println("Do you want to swap (1)/ reset tiles (2) or play game (3)?");
            Scanner r = new Scanner(System.in);
            int removal = r.nextInt();

            if(removal == 1) {
                System.out.println("you may remove tiles, select tile number");

                Scanner s = new Scanner(System.in);
                int swap = s.nextInt();

                //swap(Frame, 2);
            }
            else if(removal == 2) {
                System.out.println("you may reset tiles");
                reset(frame);
            }
            else if(removal == 3) {
                System.out.println("play game!");
            }

        }

    }

    public  void swap(Frame frame, int NumberOfLetter) {

        pool.swap(frame, NumberOfLetter);
    }

    public  void reset(char[] frameDisplay) {

        Arrays.fill(frame, ' ');

        for(int i = 0; i < frame.length; i++) {
            System.out.print("[" + frame[i] + "]");
        }

        //Pool pool;

    }

    public String toString(){
        String res = "";
        for(char letter : frame){
            res += letter + " ";
        }
        return res;
    }


}