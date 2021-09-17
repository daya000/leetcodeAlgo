package TwoPointers;

public class LongestSubstringWithoutRepeatingCharacters {
    public static String LongestSubstringWithoutRepeatingCharacters(char[] s){
        if (s==null || s.length==0) return "";
        int left = 0;
        int right = 1;
        String longestSubStr = "";
        while(right>left && right<s.length) {
            if(s[right]!=s[left]) {
                right++;
            }
            else{
                if(longestSubStr.length()<right-left){
                    longestSubStr=s.toString().substring(left,right);
                }
                left=right++;
            }
        }
        return longestSubStr;
    }
    public static void main(String[] args) {

    }
}
