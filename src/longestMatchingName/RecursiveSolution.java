package longestMatchingName;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class provides a recursive solution to find the longest common substring between two lists of names.
 * Since the problem description did not specify what should be done if two strings are eligible to be considered
 * the longestString, i.e. two different names are the longest - pesho and gosho.
 * I decided to print the first instance of the longest string.
 * With minor changes we could decide  to print the latest instance of the longest string
 * or to change the data structure that stores the longest string.
 */
public class RecursiveSolution {
    private static String longestString = "";

    public static void main(String[] args) throws IOException {
         /*
        Dynamic input from the console
        * */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstListOfNames = reader.readLine();
        String secondListOfNames = reader.readLine();

        /*
        Hardcoded values for test purposes
        String firstListOfNames = "peshogoshomishomariaina";
        String secondListOfNames = "mimianimariamanuel"; //matchind maria
        String secondListOfNames = "ffffffff"; //no match
        String firstListOfNames = "peshofgosho";
        String secondListOfNames = "peshohgosho";
        * */



        if (firstListOfNames.length() < secondListOfNames.length()) {
            findLongestString(firstListOfNames, secondListOfNames, 0, 1);
        } else {
            findLongestString(secondListOfNames, firstListOfNames, 0, 1);
        }

        System.out.println(longestString.equals("") ? "No matches" : longestString);
    }

    private static void findLongestString(String first, String second, int startIndex, int endIndex) {
        if (startIndex == first.length() ||
                endIndex > first.length() ||
                endIndex - startIndex < longestString.length()) {
            return;
        }
        String current = first.substring(startIndex, endIndex);
        if (second.contains(current) && current.length() > longestString.length()) {
            longestString = current;
        }
        findLongestString(first, second, startIndex, endIndex + 1);
        findLongestString(first, second, startIndex + 1, endIndex + 1);
    }
}
