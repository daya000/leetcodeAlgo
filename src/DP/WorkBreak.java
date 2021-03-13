package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorkBreak {

    public static boolean wordBreak(String s, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(Arrays.asList(words));
        int[] dp = new int[s.length()];
        Arrays.stream(dp).forEach(x->x=-1);
        return check(s, wordSet,0, dp);
    }

    static boolean check(String s, Set<String> dic, int startPos, int[] dp) {

        if (startPos >= s.length()) return true;
        if (dp[startPos]!=-1) return dp[startPos]==1;
        for (int i=startPos; i< s.length(); i++) {
            String subStr = s.substring(startPos, i+1);
            if(dic.contains(subStr) && check(s, dic, 0, dp)) {
                dp[i] = 1;
            }
            else {
                dp[i] = 0;
            }
        }

        return dp[s.length()-1]==1;
    }

    public static void main(String[] args) {

        String[] testStr = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak("catssanddog", testStr));

    }
}
