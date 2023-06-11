package longestMatchingName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* Iterative solution using Longest-common substring
* More information at https://en.wikipedia.org/wiki/Longest_common_substring
* */
public class IterativeSolutionOptimised {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstListOfNames = reader.readLine();
        String secondListOfNames = reader.readLine();
        
        System.out.println(longestSubString(firstListOfNames, secondListOfNames));
    }

    private static String longestSubString(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        if (maxLength == 0) {
            return "No matches";
        }

        return first.substring(endIndex - maxLength, endIndex);
    }
}
