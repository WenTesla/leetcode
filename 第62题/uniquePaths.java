package Dp;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

输入：m = 3, n = 7
输出：28
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下

输入：m = 7, n = 3
输出：28

输入：m = 3, n = 3
输出：6


 */
public class uniquePaths {
    /*
    这是一个排列组合问题，设m*n
    A（m+n-2） m-1
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：38.5 MB, 在所有 Java 提交中击败了16.95%的用户
    */
//    public int uniquePaths(int m, int n) {
//        long ans = 1;
//        for (int x = n, y = 1; y < m; ++x, ++y) {
//            ans = ans * x / y;
//        }
//        return (int) ans;
//    }
    /*
    使用动态规划
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：38.3 MB, 在所有 Java 提交中击败了49.16%的用户
     */
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
class uniquePathsTest{
    public static void main(String[] args) {
        uniquePaths test = new uniquePaths();
        System.out.println(test.uniquePaths(3,7));//1276
    }
}
