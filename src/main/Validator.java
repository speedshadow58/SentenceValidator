package main;

import java.util.Objects; //this is an import needed for the checkTheSentence method to make checking for nulls easier
//parts of this code have references to stackexchange and github but modified to be more in terms with my style of code
public class Validator extends Main {
    static int min_allowed_number = 13; //this establishes the minimum value before the number needs to typed out alphabetically

    public Validator() {
    }

    public final boolean isSentenceValid(String sentence) {
        String temp = checkTheSentence(sentence);
        return temp.length() > 1 && isConditionValid(temp);
    }

    public static boolean isConditionValid(String sentence) { //this iterates through each method in the order they are placed
        return isFirstCharacterUppercase(sentence) //and if even one returns false the sentence can no longer be valid
                && isTerminationCharAtEndOfSentence(sentence)
                && isNumOfQuotationsEven(sentence)
                && isLowestNumberLargerThan13(sentence);
    }

    public static String checkTheSentence(String sentence) {
        Objects.requireNonNull(sentence, "The sentence can't be empty," +
                " please insert a valid sentence");
        return sentence;
        //this method ensures the sentence isn't empty and prompts the user to reenter a
        //valid sentence, also providing them with an example.

    }
    public static boolean isFirstCharacterUppercase(String sentence) {
        return Character.isLetter(sentence.charAt(0)) //these two lines determine whether the first character is a letter and confirms it really is the first character
                && Character.isUpperCase(sentence.charAt(0)); //this final bit ensures that after the two previous checks, the first character is uppercase
        //this method checks whether the first character in the sentence is uppercase
        //returns true if uppercase or false if lowercase
    }

    public static int countOfGivenChar(String sentence, Character charCount) {
        int count = 0; //this is responsible for counting certain characters and is then used in the two methods below
        for (char c : sentence.toCharArray()) { //this changes the string to individual characters
            if (c == charCount) {//if both of these variables point to the same location then count gets incremented by one
                count++;
            }
        }
        return count;
    }

    public static boolean isTerminationCharAtEndOfSentence(String sentence) {
        char lastChar = sentence.charAt(sentence.length() - 1);
        return (lastChar == '.' || lastChar == '!' || lastChar == '?')
                && countOfGivenChar(sentence, lastChar) == 1;
        //this method is responsible for checking if the sentence ends in the characters
        //and only allows the sentence if there is only one
    }

    public static boolean isNumOfQuotationsEven(String sentence) {
        char quotes = '"';
        int count = countOfGivenChar(sentence, quotes);
        return count % 2 == 0;
        //this method is responsible for checking if the number of quotations in the sentence
        //is even by checking if they are divisible by two with no remainder
    }

    public static boolean isLowestNumberLargerThan13(String sentence) {
        String removeblank = sentence.replaceAll("[^-?0-9]+", " ");
        removeblank = removeblank.trim(); //this should remove all white spaces if there are any

        if (removeblank.isEmpty()) {
            return true;
        }

        int lownum = min_allowed_number;
        for (String num : removeblank.split(" ")) { //splits the string into substrings using space as a delimiter
            lownum = Math.min(lownum, Integer.parseInt(num)); //this snippet of code then finds the int value within the string and compares it to the min allowed number
            if (lownum >= 0 && lownum < 13) { //this sets the rules for the values that must be written out in text
                return false;
            }
        }

        return true;

    }

}

