package longestMatchingName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IterativeSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstListOfNames = reader.readLine();
        String secondListOfNames = reader.readLine();

        String shorter = firstListOfNames.length() < secondListOfNames.length()
                ? firstListOfNames
                : secondListOfNames;

        String longer = firstListOfNames.length() >= secondListOfNames.length()
                ? firstListOfNames
                : secondListOfNames;

        String longestSubString = "";

        for (int start = 0; start < shorter.length(); start++) {
            for (int end = start + 1; end <= shorter.length(); end++) {
                String current = shorter.substring(start, end);
                if (longer.contains(current) && current.length() > longestSubString.length()) {
                    longestSubString = current;
                }
            }
        }
        System.out.println(longestSubString);
    }
}