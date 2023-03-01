/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 */
class Solution {
	int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
	public int orangesRotting(int[][] grid) {
		if (grid.length == 1 && grid[0].length == 1) {
			if (grid[0][0] == 1) {
				return -1;
			}
			return 0;
		}
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		int goodCnt = 0;
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0;i < m;i++) {
			for (int j = 0;j < n;j++) {
				if (grid[i][j] == 2) {
					q.add(new int[]{i,j});
				} else if (grid[i][j] == 1) {
					goodCnt++;
				}
			}
		}
		while (goodCnt > 0 && !q.isEmpty()) {
			int size = q.size();
			for (int i = 0;i < size;i++) {
				int[] bad = q.poll();
				for (int[] d : dirs) {
					int x = bad[0] + d[0];
					int y = bad[1] + d[1];
					if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
						grid[x][y] = 2;
						goodCnt--;
						q.add(new int[]{x,y});
					}
				}
			}
			res++;
		}
		return goodCnt == 0 ? res : -1;
	}
}
