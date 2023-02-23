/**
 * 给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 *
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 *
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 *      所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 */
// 解1.算出[0,2^n-1]的格雷码后排序,时空O(2^n)
class Solution {
	public List<Integer> circularPermutation(int n, int start) {
		int[] g = new int[1 << n];
		int j = 0;
		for (int i = 0; i < 1 << n; ++i) {
			g[i] = i ^ (i >> 1);
			if (g[i] == start) {
				j = i;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = j; i < j + (1 << n); ++i) {
			res.add(g[i % (1 << n)]);
		}
		return res;
	}
}
// 解2.格雷码与start直接异或排出,时间O(2^n),空间O(1)(答案占用空间不计)
class Solution {
	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 1 << n; ++i) {
			res.add(i ^ (i >> 1) ^ start);
		}
		return res;
	}
}


