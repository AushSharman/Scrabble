
import java.util.Scanner;

public class Frame {

	private char [] Frame;
	private Pool pool;
	private Player player;

	
	public Frame() {
		
		Frame = new char[7];
		
		IsFrameEmpty();
		
		//checks the number of tiles
		System.out.println("Frame has: "+ Frame.length + " tile(s)");
		
		//if frame is not full
		if(Frame.length < 7) {
			
			System.out.println("Frame is not full! Access the Pool.");
			
			//while(FrameDisplay.length <= 7) {
			
				//shows current frame tiles
				System.out.println("Frame: ");
				for(int i = 0; i < Frame.length; i++) {
					System.out.print(Frame[i] + " ");
					
					}
				
			}
			
	//	}
		
		//frame should never be over 7, exception
		if(Frame.length > 7) {
			throw new RuntimeException("Frame is too big!");
		}
		
		//if frame is full
		if(Frame.length == 7) {
			System.out.println("Frame: ");
			
			//prints all tiles
			for(int i = 0; i < Frame.length; i++) {
			System.out.print(Frame[i] + " ");
			}
			
			System.out.print("\n");
			
			System.out.println("Are you happy with your tiles? (Y/N)");
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
				
		}
		
	}

	public char[] getFrame() {
		return Frame;
	}

	public void setFrame(char[] frame) {
		Frame = frame;
	}

	
	
	public static boolean IsFrameEmpty() {
		
		System.out.println("Frame isEmpty check");
		return false;
	}

	
	public static void Display() {
		
		
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