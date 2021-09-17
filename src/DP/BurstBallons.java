package DP;

public class BurstBallons {
    static int depthOfStack = 0;
    static int cacheHit = 0;

    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,5,7,8,5,3,2,5};
        System.out.println(getMaxCoinsRecurrsive(nums));
        System.out.println("Max depth: " + depthOfStack);
        System.out.println("Cache hit: " + cacheHit);

        System.out.println(getMaxCoinsDP(nums));
    }

    public static int getMaxCoinsRecurrsive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int[] num2 = new int[num.length+2];
        System.arraycopy(num, 0, num2, 1, num.length);
        int length = num2.length;
        num2[0] = 1;
        num2[length-1] = 1;
        int[][] cache = new int[length][length];

        return dfs(num2, 0, length-1, cache);
    }

    public static int dfs(int[] num, int left, int right, int[][] cache) {
        depthOfStack++;
        if (left == right -1) return 0;
        if (cache[left][right] != 0) {
            cacheHit++;
            return cache[left][right];
        }
        for (int k=left+1; k< right; k++) {
            int res = dfs(num, left, k, cache) + dfs(num, k, right, cache) + num[left] * num[right] * num[k];
            cache[left][right] = Math.max(cache[left][right], res);
        }
        return cache[left][right];
    }

    //用递推模拟回归过程的方法，就是在上述实现的缓存 cache[i][j] 中逐渐推演，通过一步步的解决小问题来得到最终问题的解，这便是动态规划解法。

    public static int getMaxCoinsDP(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int[] num2 = new int[num.length+2];
        System.arraycopy(num, 0, num2, 1, num.length);
        int length = num2.length;
        num2[0] = 1;
        num2[length-1] = 1;
        int[][] dp = new int[length][length];

        // i, j 为子问题左右边界
        for (int i = length - 2; i >= 0; i --) {
            for (int j = i+2; j < length; j++){
                int max = 0;
                for (int k = i+1; k < j; k++) {
                    int res = num2[j] * num2[k] * num2[i] + dp[i][k] + dp[k][j];
                    max = Math.max(res, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length-1];
    }
}
