import java.util.Scanner;

public class Scrabble
{
    //    public static long[] words;
//    private static int[] words;
    private Pool pool;
    private Board board;
    public static Player p1, p2;
    public static int p1Turn ;
    public static int p2Turn;
    public static int counter;
    Scanner scanIn;

    //Game is over when all the tiles from the Pool is drawn
    public Scrabble() {
        pool = new Pool();
        board = new Board();

        p2Turn = 1;
        scanIn = new Scanner(System.in);
    }


    public void getPlayerInput() {
        System.out.println("Enter Player-One Name : ");
        String player1 = scanIn.next();
        System.out.println("Enter Player-Two Name");
        String player2 = scanIn.next();
        System.out.println(player1 + " VS " + player2);
        p1 = new Player(player1);
        p2 = new Player(player2);
    }


    public void executeOption(Player player, String opt) {
        switch (opt) {
            case "Quit":
                System.out.println("Quitting Game");
                System.exit(-1);
                break;
            case "Pass":    //Pass option works fine - SOUT a message and switch counter value
                System.out.println("Turn is now - " + (!(counter % 2 == 0) ? p1.getPlayerName() : p2.getPlayerName()));
                if(counter == p1Turn)
                {
                    counter = p2Turn;
                }
                else
                {
                    counter = p1Turn;
                }
                break;
            case "Exchange":    //Need to write the exchange method - Frame.swap()
                System.out.print("What letters would you like to exchange from your Frame");
                String s = scanIn.nextLine();
                char[] chars = s.toCharArray();
                for (char letter : chars) {
                    if (letter != ' ') Frame.swap(player.getFrame(), letter);
                    System.out.println(player.getPlayerName() + " now has the Frame " + player.getFrame());

                }
                if(counter == p1Turn)
                {
                    counter = p2Turn;
                }
                else
                {
                    counter = p1Turn;
                }
                break;
            case "Challenge":
                System.out.println("What word do you wish to challenge : ");
                String word = scanIn.nextLine();
                Player.challenge(word, (counter == p2Turn)? p1 : p2);
                if (Player.isWordInFile(word) == true)
                {
                    if(counter == p1Turn)
                    {
                        counter = p1Turn;
                    }
                    else
                    {
                        counter = p2Turn;
                    }
                }
                else
                {
                    if(counter == p1Turn)
                    {
                        counter = p2Turn;
                    }
                    else
                    {
                        counter = p1Turn;
                    }
                }

                System.out.println(!(counter == p2Turn)? p1.getPlayerName(): p2.getPlayerName() + " now has " + player.getPlayerScore() + " points");

                break;
            default:
                board.getBoardInput(player);
                board.display();
                System.out.println(player.getPlayerName() + " has " + player.getPlayerScore() + " points");
                if(counter == p1Turn)
                {
                    counter = p2Turn;
                }
                else
                {
                    counter = p1Turn;
                }
                break;
        }
    }

    public void playGame() {
//        System.out.println("");
        getPlayerInput();
        while (!Pool.isPoolEmpty() ) {      //Maintain a loop - so the game plays
            if (counter % 2 == 0) {     //If counter is odd - then Player2 turn else Player1 turn
                System.out.println(p1.getPlayerName() + "-" + p1.getFrame());
                System.out.println("Enter User Command : [Place] [Challenge] [Quit] [Pass] [Exchange]");    //Display Options for player to enter
                String option = scanIn.next();
                scanIn.nextLine();
                executeOption(p1, option);
            } else{
                System.out.println(p2.getPlayerName() + "-" + p2.getFrame());
                System.out.print("Enter User Command :[Place] [Challenge] [Quit] [Pass] [Exchange] ");
                String option = scanIn.next();
                scanIn.nextLine();
                executeOption(p2, option);
            }
        }
    }
    //If you wish to play the Challenge Option - enter the letters as a String - e.g "I wish to challenge the word ASDF"
    public static void main(String[] args) {
        Scrabble s = new Scrabble();
//        System.out.println(words);
        s.playGame();
    }
}



