package Dp2;

import java.util.Arrays;

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。

你可以认为每种硬币的数量是无限的。

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

输入：coins = [2], amount = 3
输出：-1

输入：coins = [1], amount = 0
输出：0

 */
public class coinChange {
    /*
    动态规划
    首先没把所有元素填充比较大的值
    改进后将所有元素填充int的最大值，发现如果+1会越界，不好判断是否越界
    查看答案后要填充amout+1，最大填充数必须大于amout（按硬币面额为1的情况下）

    执行用时：12 ms, 在所有 Java 提交中击败了69.55%的用户
    内存消耗：40.8 MB, 在所有 Java 提交中击败了82.62%的用户
     */
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        int x=0;
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                x=coins[j];
                if (i - x >= 0)
                dp[i]=Math.min(dp[i],dp[i-x]+1);
            }
        }
        if (dp[amount]>=amount+1)
            return -1;
        return dp[amount];

    }
}
class cointest{
    public static void main(String[] args) {
        coinChange change = new coinChange();
        System.out.println(change.coinChange(new int[]{1,2,5},11));
        System.out.println(change.coinChange(new int[]{2},3));
    }
}
