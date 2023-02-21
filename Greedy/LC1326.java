/**
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 *
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 *
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 *
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 *
 * 输入：n = 5, ranges = [3,4,1,1,0,0]
 * 输出：1
 * 解释：
 * 点 0 处的水龙头可以灌溉区间 [-3,3]
 * 点 1 处的水龙头可以灌溉区间 [-3,5]
 * 点 2 处的水龙头可以灌溉区间 [1,3]
 * 点 3 处的水龙头可以灌溉区间 [2,4]
 * 点 4 处的水龙头可以灌溉区间 [4,4]
 * 点 5 处的水龙头可以灌溉区间 [5,5]
 * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
 */
class Solution {
	public int minTaps(int n, int[] ranges) {
		// 记录i点下最远到达的右端点
		int[] maxRight = new int[n + 1];
		int res = 0;
		for (int i = 0;i < n + 1;i++) {
			// 防止越界
			int l = Math.max(0,i - ranges[i]);
			int r = Math.min(n,i + ranges[i]);
			maxRight[l] = Math.max(maxRight[l],r);
		}
		int cur = 0;
		int r = 0;
		// 更新每个点下最远到达右端点
		for (int i = 0;i < n;i++) {
			r = Math.max(r,maxRight[i]);
			// 最远右端点到达不了目前点
			if (r <= i) {
				return -1;
			}
			// 更新右端点，当前点
			if (cur == i) {
				cur = r;
				res++;
			}
		}
		return res;
	}
}
