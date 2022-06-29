
/*
给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

返回 你可以获得的最大乘积 。

输入: n = 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

输入: n = 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
执行用时：1 ms, 在所有 Java 提交中击败了77.39%的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了59.11%的用户
 */
public class integerBreak {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <= n; i++) {
            int max=0;
            for (int j = 1; j < i; j++) {
                max=Math.max(max,Math.max(j*dp[i-j],j*(i-j)));//两者取舍，一种裁分，一种不裁开
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
