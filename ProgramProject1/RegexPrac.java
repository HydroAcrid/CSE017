import java.util.regex.*;
import java.util.*;

public class RegexPrac {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Input code like this: ");
        System.out.println("B-ddd-ddd-ddd");
        System.out.println("Or P-ddd-ddd-ddd");


        boolean matches = false;
        String regexPattern = "B-([0-9]+(-[0-9]+)+)";
        String inputText = "B-111-222-333";
        String regexPatternTest = "B-[0-9]{3}+-[0-9]{3}+-[0-9]+{3}";


        matches = Pattern.matches(regexPattern, inputText);
        printMatchedResult(matches);

        System.out.println("Input the previous pattern: ");
        String selfInput = scnr.next();

        matches = Pattern.matches(regexPattern, selfInput);
        printMatchedResult(matches);

        matches = Pattern.matches(regexPatternTest, selfInput);
        printMatchedResult(matches);


    }

    private static void printMatchedResult(boolean matches) {
        if(matches) {
            System.out.println("Nice match");
        }
        else {
            System.out.println("Bad match yikes");
        }
    }
}
