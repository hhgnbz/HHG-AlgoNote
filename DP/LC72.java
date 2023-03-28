/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }
        // 思路：类似于最长公共子序列
        // 把 取/不取 转换为 插入/删除/替换
        // 前一字符相同：当前无操作dp[i][j] = dp[i - 1][j - 1];
        // 字符不相同：对比插入dp[i - 1][j]，删除dp[i][j - 1]，替换dp[i - 1][j - 1]三者中最小操作步数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i++) {
            dp[i][0] = i;
        }
        for (int j = 1;j <= n;j++) {
            dp[0][j] = j;
        }
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i][j - 1],dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}