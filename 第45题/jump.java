package Dp;

import java.util.Arrays;

/*
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。

输入: nums = [2,3,0,1,4]
输出: 2

 */
public class jump {
    /*
    正向查找
     */
//    public int jump(int[] nums) {
//        int n= nums.length;
//        int max=0;//最远距离
//        int end=0;//上次能跳的最远距离
//        int step=0;
//        for (int i = 0; i < n - 1; i++) {
//            max=Math.max(max,i+nums[i]);
//            if (i == end){//到达上次最远的地方
//                end = max;
//                step++;
//            }
//        }
//        return step;
//    }
    /*
    动态规划
    执行用时：323 ms, 在所有 Java 提交中击败了5.02%的用户
    内存消耗：41.5 MB, 在所有 Java 提交中击败了86.94%的用户
     */
//    public int jump(int[] nums){
//        int[] dp=new int[nums.length];
//        //给所有dp数组填充最大值
//        Arrays.fill(dp,Integer.MAX_VALUE);
//        dp[0]=0;
//        for (int i = 1; i < nums.length; i++) {
//            //外侧从1开始遍历，因为第一个必然能跳到
//            for (int j = 0; j < i; j++) {
//                //开始遍历,未优化版本每次从0开始计算,一直到i-1
//                if (j+nums[j]>=i){
//                    dp[i]=Math.min(dp[j]+1,dp[i]);
//                }
//            }
//        }
//        return dp[nums.length-1];
//    }
    /*
    动态规划（优化后）
    执行用时：29 ms, 在所有 Java 提交中击败了19.42%的用户
    内存消耗：41.6 MB, 在所有 Java 提交中击败了84.68%的用户
     */
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int[] dp = new int[nums.length];
        //给所有dp数组填充最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = i + nums[i];
            if (temp >= nums.length - 1) {
                return dp[i] + 1;
            }
            for (int j = i + 1; j <= temp; j++) {
                if (i + nums[i] < dp[j]) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}

class testJump {
    public static void main(String[] args) {
        jump jump = new jump();
        System.out.println(jump.jump(new int[]{1, 2, 3}));
    }
}
