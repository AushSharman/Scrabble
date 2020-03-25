package sample;

import java.util.Scanner;

public class UI
{
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
