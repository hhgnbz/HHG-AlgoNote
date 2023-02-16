/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]],
 *      word = "ABCCED"
 * 输出：true
 */
class Solution {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		char[] sc = word.toCharArray();
		boolean[][] used = new boolean[m][n];
		for (int i = 0;i < m;i++) {
			for (int j = 0;j < n;j++) {
				if (dfs(board,sc,i,j,0,used)) {
					return true;
				}
			}
		}
		return false;
	}
	boolean dfs(char[][] board,char[] sc,int x,int y,int depth,boolean[][] used) {
		if (x >= board.length || y >= board[0].length || x < 0 || y < 0 || depth >= sc.length || sc[depth] != board[x][y] || used[x][y]) {
			return false;
		}
		if (depth == sc.length - 1) {
			return true;
		}
		used[x][y] = true;
		boolean check = dfs(board,sc,x + 1,y,depth + 1,used) ||
				dfs(board,sc,x - 1,y,depth + 1,used) ||
				dfs(board,sc,x,y + 1,depth + 1,used) ||
				dfs(board,sc,x,y - 1,depth + 1,used);
		used[x][y] = false;
		return check;
	}
}
