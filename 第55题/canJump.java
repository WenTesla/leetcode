package Dp;
/*
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标
执行用时：2 ms, 在所有 Java 提交中击败了94.20%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了26.24%的用户
 */
public class canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return true;
        int max=0;
        for (int i = 0; i <= max; i++) {
            if (i+nums[i] > max)
                max = i+nums[i];
            if (max >= n-1)
                return true;
        }
//        if (max >= n)
//            return true;
        return false;
    }
}
class canJumpTest{
    public static void main(String[] args) {
        canJump canJump = new canJump();
//        System.out.println(canJump.canJump(new int[]{3,2,1,0,4}));
//        System.out.println(canJump.canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump.canJump(new int[]{2,0,0}));
    }
}
