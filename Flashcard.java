/**
 * Created by Luhmelle on 8/11/2016.
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class Flashcard {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {


        //intro
        System.out.println("Welcome to Flashcard program");
        System.out.println("1 - Review Existing Flashcards");
        System.out.println("2 - Make New Set of Flashcards");
        //option
        System.out.print("> ");
        String choice = s.next();
        System.out.println();
        //begin to read or write
        if (choice.equals("1")) {
            System.out.println("Enter location and filename of flashcard set");
            System.out.print("> ");
            String fileName = s.next();
            System.out.println();
            readCards(fileName);
            //System.out.println(cardSetLength(fileName));
        } else {
            System.out.println("Enter location and filename of the new flashcard set");
            System.out.print("> ");
            String fileName = s.next();
            System.out.println();
            makeCards(fileName);
        }
    }

    public static void makeCards(String fileLocation){
        // assume our filename is stored in the string fileName

        PrintWriter p = null; // declare p outside try-catch blockA

        try {
            p = new PrintWriter(new File(fileLocation));
        } catch (Exception e) {}
        //two strings to represent each side of the flashcard
        String frontSide = "";
        String backSide = "";
        //continue creating cards until user types !stop
        while (frontSide.equals("!stop") == false){
            System.out.print("Front Side: ");
            frontSide = s.next();
            System.out.println();
            if (frontSide.equals("!stop") == false) {
                System.out.print("Back Side: ");
                backSide = s.next();
                System.out.println();
                p.println(frontSide);
                p.println(backSide);
            }
        }

        p.close(); // close the file to preserve what was written to it.
    }

    public static void readCards(String cardSet){
        // assume our filename is stored in the string fileName

        int cycles = 0; //determines how many cards you will study
        while(cycles < 10){

            ////////

            Scanner scan = null; // declare s outside try-catch block

            try {
                scan = new Scanner(new File(cardSet));

            } catch (Exception e) {}

            //////

            int randomLine = 2;
            //only get odd numbers for frontside to backside
            while (randomLine % 2 == 0){
                randomLine = 1 + (int)(Math.random() * cardSetLength(cardSet));
            }

            String line = scan.nextLine();
            for (int i = 1; i < randomLine && s.hasNextLine(); i++){
                line = scan.nextLine();
            }

            System.out.print(line + " = ");
            String user_answer = s.next();
            System.out.println();
            String answer = scan.nextLine();
            if (user_answer.equals(answer))
                System.out.println("Correct!");
            else
                System.out.println("Incorrect, correct answer is: " + answer);
            System.out.println();
            cycles++;
        }
    }

    public static int cardSetLength(String cardSet){
        Scanner scan = null; // declare s outside try-catch block

        try {
            scan = new Scanner(new File(cardSet));

        } catch (Exception e) {}
        int lineNumber = 1;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            lineNumber++;
        }

        return lineNumber - 1;
    }
}
