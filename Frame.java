
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
		
	//	System.out.println("Frame isEmpty check");
		
		if(Frame == null) {
			System.out.println("Frame is Empty");
			return false;
		}
		else {
			return true;
		}
	}

	
	public static void Display() {
		
	//IsFrameEmpty();
		
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
			
/*			System.out.println("Are you happy with your tiles? (Y/N)");
			Scanner r = new Scanner(System.in);
			String removal = r.nextLine();
			
			if(removal == "n" || removal == "N") {
				System.out.println("you may remove tiles");
				//swap();
			}
			else if(removal == "y" || removal == "Y") {
				System.out.println("play game!");
			}
			else {
				System.out.println("unsure...");
			}
	*/			
		}
		
	}
	
	public void swap(char[] frameDisplay, char letter) {
			
		Pool pool;
		
	}
	
	public void reset(char[] frameDisplay) {
		
	}
	
	public static void main(String[] args) {
		
		
		
		Display();

	}

}