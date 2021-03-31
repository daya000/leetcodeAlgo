package DP;

public class minCoins {

    public static int getMinCoins(int[] coinList, int money) {
        int counter = 0;
        if (money == 0) return 0;
        int[] dp = new int[money+1];

        for (int i=1; i<=money; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=0; j<coinList.length; j++) {
                if (i < coinList[j] || dp[i-coinList[j]]==Integer.MAX_VALUE) continue;
                else {
                    counter++;
                    dp[i] = Math.min(dp[i], 1 + dp[i-coinList[j]]);
                }
            }
        }
        System.out.println(counter);
        return dp[money]==Integer.MAX_VALUE ?-1:dp[money];
    }

    public static void main(String[] args) {

        int[] coinList = new int[] {1,2,5};
        System.out.println(getMinCoins(coinList, 11));

    }
}
