package JUnitTests;
import main.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    String exampleSentence; //what is to be used in the tests
    boolean result; //what the result is after running the method called

    @Test
    void testIsFirstCharacterUppercase() { //checks if the first letter is uppercase
        exampleSentence = "There are \"13\" dogs in the kennel"; //sentence that is checked
        result = Validator.isFirstCharacterUppercase(exampleSentence); //runs the method from the Validator class
        Assertions.assertTrue(result); //checks if the result is true
    }

    @Test
    void testIsTerminationCharAtEndOfSentence() { //checks if there is a termination character at the end of sentence
        exampleSentence = "There are \"13\" dogs in the kennel."; //sentence that is checked
        result = Validator.isTerminationCharAtEndOfSentence(exampleSentence); //runs the method from the Validator class
        Assertions.assertTrue(result); //checks if the result is true
    }

    @Test
    void testIsNumOfQuotationsEven() { //checks for an even amount of quotation marks
        exampleSentence = "There are \"13\" dogs in the kennel."; //sentence that is checked
        result = Validator.isNumOfQuotationsEven(exampleSentence); //runs the method from the Validator class
        Assertions.assertTrue(result); //checks if the result is true
    }

    @Test
    void testNumLowerThan13() { //checks if the value is lower than 13
        exampleSentence = "There are \"8\" dogs in the kennel."; //sentence that is checked
        result = Validator.isLowestNumberLargerThan13(exampleSentence); //runs the method from the Validator class
        Assertions.assertFalse(result); //checks if the result is true
    }
    @Test
    void testTypedLowNum() { //checks if the value is lower than 13
        exampleSentence = "There are \"seven\" dogs in the kennel."; //sentence that is checked
        result = Validator.isLowestNumberLargerThan13(exampleSentence); //runs the method from the Validator class
        Assertions.assertTrue(result); //checks if the result is true
    }
    @Test
    void testNumLargerThan13() { //checks if the value is larger than 13
        exampleSentence = "There are \"14\" dogs in the kennel."; //sentence that is checked
        result = Validator.isLowestNumberLargerThan13(exampleSentence); //runs the method from the Validator class
        Assertions.assertTrue(result); //checks if the result is true
    }
    @Test
    void testTwoFullStops() { //this checks if there is more than one termination character
        exampleSentence = "There are \"13\" dogs. in the kennel."; //sentence that is checked
        result = Validator.isConditionValid(exampleSentence); //runs the method from the Validator class
        Assertions.assertFalse(result); //checks if the result is true
    }
}

