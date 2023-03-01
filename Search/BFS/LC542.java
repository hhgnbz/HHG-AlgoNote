/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 */
class Solution {
	int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	public int[][] updateMatrix(int[][] mat) {
		Deque<int[]> q = new ArrayDeque<>();
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0;i < m;i++) {
			for (int j = 0;j < n;j++) {
				if (mat[i][j] == 0) {
					q.add(new int[]{i,j});
				} else {
					mat[i][j] = -1;
				}
			}
		}
		while(!q.isEmpty()) {
			int[] z = q.poll();
			for (int[] d : dirs) {
				int x = z[0] + d[0];
				int y = z[1] + d[1];
				if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == -1) {
					mat[x][y] = mat[z[0]][z[1]] + 1;
					q.add(new int[]{x,y});
				}
			}
		}
		return mat;
	}
}
