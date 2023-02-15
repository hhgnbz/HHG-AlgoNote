/**
 * 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 * 假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 *
 * 输入：nums = [12,5,7,23]
 * 输出：true
 * 解释：挑选数字 5 和 7。
 * 5*3 + 7*(-2) = 1
 */
class Solution {
	int gcd(int a,int b) {
		return b == 0 ? a : gcd(b,a % b);
	}
	public boolean isGoodArray(int[] nums) {
		int temp = nums[0];
		for (int i = 1;i < nums.length;i++) {
			temp = gcd(temp,nums[i]);
			if (temp == 1) {
				return true;
			}
		}
		return false;
	}
}
