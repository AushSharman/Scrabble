package sample;

import java.util.Scanner;

public class UI
{
    //QUIT button method :
    //TO DO : create a method that gathers together all reset methods from previous classes .
    public static void quitButton()
    {
        
    }

    //PASS button method :
    //TO DO : allows a player to skip their turn in game .
    public static void passButton(int counter)
    {

    }

    //HELP button method :
    //TO DO : create a method that provides player with helps when getting stuck for placing words on board .
    public static void helpButton()
    {

    }

    //EXCHANGE button method :
    //TO DO : uses the exchange method to replace existing tiles on frame with new random tiles from pool .
    public static void exchangeButton()
    {
        Scanner scanIn = new Scanner(System.in);
        Player player = new Player("John");
        System.out.print("What letters would you like to exchange from your Frame");
        String s = scanIn.nextLine();
        char[] chars = s.toCharArray();

        for (char letter : chars)
        {
            if (letter != ' ') Frame.swap(player.getFrame(), letter);
        }

        System.out.println(s + " has now the Frame - " + player.getFrame());
    }
}
