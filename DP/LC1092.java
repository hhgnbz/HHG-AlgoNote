/**
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 *
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 *
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 */
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // LCS
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        // bulid
        // 思路：
        // str1:       a   b   a   c
        // str2:   c   a   b
        // res:    c   a   b   a   c
        // dp[m][n] == dp[m][n - 1] 证明 在求得LCS时 去除了str2的n-1位置
        // dp[m][n] == dp[m - 1][n] 同上
        // 其他情况则为同时去除了str1和str2，即为字符相同情况
        StringBuilder sb = new StringBuilder();
        while (m > 0 || n > 0) {
            if (m == 0) {
                sb.append(str2.charAt(n - 1));
                n--;
            } else if (n == 0) {
                sb.append(str1.charAt(m - 1));
                m--;
            } else {
                if (dp[m][n] == dp[m][n - 1]) {
                    sb.append(str2.charAt(n - 1));
                    n--;
                } else if (dp[m][n] == dp[m - 1][n]) {
                    sb.append(str1.charAt(m - 1));
                    m--;
                } else {
                    sb.append(str1.charAt(m - 1));
                    m--;
                    n--;
                }
            }

        }
        return sb.reverse().toString();
    }
}