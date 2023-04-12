/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int cnt = 1;
        int res = 0;
        for (int right = 0;right < nums.length;right++) {
            cnt *= nums[right];
            while (cnt >= k && left <= right) {
                cnt /= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}