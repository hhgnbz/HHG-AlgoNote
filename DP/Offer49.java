/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 1是丑数。
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
class Solution {
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 1;i < n;i++) {
			int na = dp[a] * 2;
			int nb = dp[b] * 3;
			int nc = dp[c] * 5;
			dp[i] = Math.min(Math.min(na,nb),nc);
			if (dp[i] == na) {
				a++;
			}
			if (dp[i] == nb) {
				b++;
			}
			if (dp[i] == nc) {
				c++;
			}
		}
		return dp[n - 1];
	}
}
