//updated Frame


import java.util.Scanner;

public class Frame {

	private static char [] Frame = {'a', 'a', 'b', 'c', 'e', 'r', 's'};
	private Pool pool;
	private Player player;

	
	public Frame() {
		
		Frame = new char[7];
		
	}

	public char[] getFrame() {
		return Frame;
	}

	public void setFrame(char[] frame) {
		Frame = frame;
	}

	
	
	public static boolean IsFrameEmpty() {
		
		if(Frame == null) {
			System.out.println("Frame is Empty");
			return false;
		}
		else {
			return true;
		}
	}

	
	public static void Display() {
		
	//if frame is empty, access the pool
		if(IsFrameEmpty() == false) {
			
			System.out.println("Frame is not full! Access the Pool.");
			Pool pool;
			
		}
		else {
			//else if frame has at least 1 tile, check amount 
			
			System.out.println("Frame has: "+ Frame.length + " tile(s)");
		}
		
		//frame should never be over 7, exception
		if(Frame.length > 7) {
			throw new RuntimeException("Frame is too big!");
		}
		
		//if frame is full
		if(Frame.length == 7) {
			System.out.println("Frame: ");
			
			//prints all tiles
			for(int i = 0; i < Frame.length; i++) {
			System.out.print("[" + Frame[i] + "]");
			}
			
			System.out.print("\n");
			
			System.out.println("Do you want to swap (1)/ reset tiles (2) or play game (3)?");
			Scanner r = new Scanner(System.in);
			int removal = r.nextInt();
			
			if(removal == 1) {
				System.out.println("you may remove tiles, select tile number");
				
				Scanner s = new Scanner(System.in);
				int swap = s.nextInt();
				
				swap(Frame, Frame[swap]);
			}
			else if(removal == 2) {
				System.out.println("you may reset tiles");
				reset(Frame);
			}
			else if(removal == 3) {
				System.out.println("play game!");
			}
				
		}
		
	}
	
	public static void swap(char[] frameDisplay, char letter) {
			
		Pool pool;
		
	}
	
	public static void reset(char[] frameDisplay) {
		Pool pool;
	}
	
	public static void main(String[] args) {
		
		Display();

	}

}