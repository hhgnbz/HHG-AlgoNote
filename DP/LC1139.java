/**
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 */
class Solution {
	public int largest1BorderedSquare(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] rows = new int[m][n + 1];
		int[][] cols = new int[n][m + 1];
		for (int i = 0; i < m; ++i){
			for (int j = 0; j < n; ++j) {
				rows[i][j + 1] = rows[i][j] + grid[i][j];
				cols[j][i + 1] = cols[j][i] + grid[i][j];
			}
		}
		for (int d = Math.min(m, n); d > 0; --d) {
			for (int i = 0; i <= m - d; ++i) {
				for (int j = 0; j <= n - d; ++j) {
					if (rows[i][j + d] - rows[i][j] == d &&
							cols[j][i + d] - cols[j][i] == d &&
							rows[i + d - 1][j + d] - rows[i + d - 1][j] == d &&
							cols[j + d - 1][i + d] - cols[j + d - 1][i] == d) {
						return d * d;
					}
				}
			}
		}
		return 0;
	}
}
