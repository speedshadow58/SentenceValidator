package main;

import java.util.Scanner; //imports scanner tool so user can input sentence

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while (!valid) { //checks to see if the boolean valid is still false and if so continues with the program
            System.out.println("Please enter your sentence : ");
            String sentence = scanner.nextLine();
            valid = validator.isSentenceValid(sentence); //this calls the isSentenceValid method for the main.Validator class

            if (!valid) { //if the sentence is still invalid, it will then display this error for the user and prompt them to try again
                System.out.println("This is invalid, please try again");
                System.out.println("Here is an example for help : There are '13' dogs in the kennel.");
            }
        }
        System.out.println("This is valid, good job!");

    }


}



