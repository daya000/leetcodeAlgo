package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String s, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(Arrays.asList(words));
        int[] dp = new int[s.length()];
        for (int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }
        return check(s, wordSet,0, dp)==1;
    }

    static int check(String s, Set<String> dic, int startPos, int[] dp) {

        System.out.println("starting position: " + startPos);
        if (startPos >= s.length()) return 1;
        if (dp[startPos]!=-1) return dp[startPos];
        for (int i=startPos; i< s.length(); i++) {
            String subStr = s.substring(startPos, i+1);
            System.out.println("Sub string is :  "+subStr);
            if(dic.contains(subStr) && check(s, dic, i+1, dp)==1) {
                dp[startPos] = 1;
                return 1;
            }
        }
        dp[startPos] = 0;
        return dp[startPos];
    }

    public static void main(String[] args) {

        String[] testStr = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak("catssandog", testStr));

    }
}
