
import java.util.Arrays;
import java.util.Scanner;

// S-u-z    -> Suzanne Byrne -> 18321676

public class Frame {
    private Tiles[] frame;

    public Frame() {
        frame = new Tiles[7];   //Create a array of Tiles
        Pool.drawTiles(this, 7);
    }
    /*
The Frame is made up of Tile[]
	and every Tile - [letter, NumOfOccurrances]
	this is the exact same as the Pool - modify frame to only have Tiles*/


    //frame getters and setters
    public Tiles[] getFrame() {
        return frame;
    }


    //function to check if frame is empty
    public boolean IsFrameEmpty() {
        for (Tiles tiles : frame) {
            if (tiles != null) return false;
        }
        System.out.println("Player frame is empty");
        return true;
    }


    //swap function, swaps select number of tiles from the pool function
    public static void swap(Frame frame, int NumberOfLetter) {
        for (int index = 0; index < NumberOfLetter; index++) {
//            System.out.println(frame.getFrame().length);
            int randomIndex = (int) (Math.random() * frame.getFrame().length);
//Get a random Index from the Frame - of Type Tiles[]
            if (frame.getFrame()[randomIndex] == null) {
                swap(frame, NumberOfLetter-index);
                return;
            }
            else {
                Pool.addTileBack(frame.getFrame()[randomIndex]);
                frame.getFrame()[randomIndex] = null;
            }
        }
        // TODO: 17/03/2020 If the randomIndex == one of the elements == null -> Exception thrown
//Incrementing Pool values by 1 - then setting the frameValue to null and calling the
//Pool draw to assign randomTiles
        Pool.drawTiles(frame, 7);
    }

    public void removeTile(char letter) { //Removes the Tile from the Frame
        if (hasFrameTile(letter)) {
            for (int i = 0; i < frame.length; i++) {
                if (frame[i] == null) continue;
                if (frame[i].getLetter() == letter) {
//                    Pool.reduceTileCount(frame[i]);
                    System.out.println("Pool has " + Pool.getTotalTiles());
                    frame[i] = null;
                    break;
                }
            }
        } else{
            System.out.println("Cannot remove Tile " + letter + " that is not in the Frame");
        }
    }

    /*When a player places the Tiles on the Board - The tiles should be removed(set to null) from their Frame - and the
    * player takes in new Tiles from the Pool */
    public void refill(){
//        System.out.println("Before refill");
        Pool.drawTiles(this, 7);
//        System.out.println("After Frame refill - " + Arrays.toString(frame));
    }

    public boolean hasFrameTile(char letter) {       //Checks if the Frame has the Tile
        for (Tiles t : frame) {
            if (t == null) continue;
            if (t.getLetter() == letter) {
//                System.out.println("The tile is in the Frame");
                return true;
            }
        }
//        System.out.println("Tile is not in the Frame");
        return false;
    }


    //reset function, empties the frame
    public void resetFrame() {
        frame = null;
        System.out.println("Frame is now empty - []");
    }

    //returns the frame as a string
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Tiles t : frame) {
            if (t != null) {
                sb.append(t.getLetter()).append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
//        System.out.println(pool);
        Frame frame = new Frame();  //works fine upto here
        System.out.println(frame);
        frame.removeTile(frame.getFrame()[0].getLetter());
//        System.out.println("Remove the first = " + frame);
        frame.refill();
        System.out.println(frame);//works fine upto here
        Frame.swap(frame, 5);
        System.out.println(frame);
        System.out.println(pool);

    }

}
