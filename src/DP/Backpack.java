package DP;

public class Backpack {

    //additional for loop for initial case, not recommended
    public static int backPack(int[] v, int[] w, int c) {
        int[][] dp = new int[v.length][c+1];
        for(int i=0; i<=c; i++){
            dp[0][i] = w[0] <= i ? v[0]:0;
        }
        for(int i=1; i<v.length; i++) {
            for(int j=0; j<=c; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        return dp[v.length-1][c];
    }

    // standard method with no space optimization
    public static int backPack2DArray(int[] v, int[] w, int c) {
        int[][] dp = new int[v.length+1][c+1];
        for (int i=1; i<=v.length; i++) {
            for (int j=0; j<=c; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>=w[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }
        return dp[v.length][c];

    }

    public static int backPack1DArray(int[] v, int[] w, int c) {
        int[] dp = new int[c+1];
        for(int i=0; i<v.length; i++) {
            for (int j=c; j>=0; j--) {
                if(j>=w[i] && dp[j-w[i]] + v[i]> dp[j]) {
                    dp[j] = dp[j-w[i]] + v[i];
                }
            }
        }
        return dp[c];
    }

    public static void main(String[] args) {
        int[] w = {2,1,3,2};
        int[] v = {12,10,20,15};
        System.out.println(backPack1DArray(v,w,5));
    }
}
