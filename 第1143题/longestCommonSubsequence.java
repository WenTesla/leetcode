package Dp2;
/*

 */
public class longestCommonSubsequence {
    /*
    因为i与j指向的字符相同，所以直接+1在i-1和j-1的字符串基础上加一
    如果不同，则取i-1，j或者i，j-1的最大字符串的最大值
    Try dynamic programming. DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
    DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
    执行用时：9 ms, 在所有 Java 提交中击败了75.85%的用户
    内存消耗：44.9 MB, 在所有 Java 提交中击败了73.41%的用户
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
class testlong{
    public static void main(String[] args) {
        longestCommonSubsequence subsequence = new longestCommonSubsequence();
        System.out.println(subsequence.longestCommonSubsequence("abcde","ace"));
    }
}
