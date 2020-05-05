import com.sun.corba.se.impl.encoding.CodeSetConversion;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bot0 implements BotAPI {

    // The public API of Bot must not change
    // This is ONLY class that you can edit in the program
    // Rename Bot to the name of your team. Use camel case.
    // Bot may not alter the state of the game objects
    // It may only inspect the state of the board and the player objects

    private PlayerAPI me;
    private OpponentAPI opponent;
    private BoardAPI board;
    private UserInterfaceAPI info;
    private DictionaryAPI dictionary;
    private int turnCount;
    private static Scrabble s;
    private static Scanner scan;

    Bot0(PlayerAPI me, OpponentAPI opponent, BoardAPI board, UserInterfaceAPI ui, DictionaryAPI dictionary) throws FileNotFoundException {
        this.me = me;
        this.opponent = opponent;
        this.board = board;
        this.info = ui;
        this.dictionary = dictionary;
        turnCount = 0;
        s = new Scrabble();
    }




    //Take in the board, frame,
    //ABC - {A, ACB, ABC, B, BAC, BCA, C, CAB, CBA} 2^n + 1
    //append(A) to makeSubset(B,C) -> {ABC, ACB}
    public static ArrayList<String> permutation(String s) {
        // The result
        ArrayList<String> res = new ArrayList<String>();
        // If input string's length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = merge(permutation(rest), last);
        }
        return res;
    }


    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<>();
        // Loop through all the string in the list
        for (String s : list) {
            // For each string, insert the last character to all possible positions
            // and add them to the new list
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
    private static String tileToString(ArrayList<Tile> s){
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < s.size(); i++){
            ret.append(Character.toString(s.get(i).getLetter()));
        }

        return ret.toString();
    }

    private static String check(String r){
        int l = (int) (Math.random() * 25);
        r = r.replace("_", Character.toString((char) ((char)l + (char)65)));

        return r;
    }

    private static void checkBlanks(ArrayList<String> word){
        for (int i = 0; i < word.size(); i++){
            if (word.get(i).contains("_"))
                word.set(i, check(word.get(i)));
        }
    }

//    public static boolean dictionaryCheck(ArrayList<String> word) {
//        for (String s : word){
//            if ()
//        }
//    }

    /*public ArrayList<String> makeWord() {//Get the Player Frame and make combinations of words
        //To make Combinations of Words -> make subsets of the Frame
        Frame playerFrame = s.getCurrentPlayer().getFrame();
        ArrayList<Tile> k = playerFrame.getTiles();

        ArrayList<String> computedWords = permutation(tileToString(k));

        return computedWords;
    }*/


    public String getCommand() {
        // Add your code here to input your commands
        // Your code must give the command NAME <botname> at the start of the game
        String command = "";
        switch (turnCount) {
            case 0:
                command = "NAME Bot0";
                break;
            case 1:
                command = "Pass";
            case 2:
                command = "HELP";
                break;
            case 3:
                command = "SCORE";
                break;
            case 4:
                command = "POOL";
                break;
            default:
//                command = makeWord().toString();
                break;
        }
        turnCount++;
        return command;
    }

    public static void main(String[] args) {
//        System.out.println(Bot0.permutation("AOLPEWR"));

        System.out.println(s);

    }

}
