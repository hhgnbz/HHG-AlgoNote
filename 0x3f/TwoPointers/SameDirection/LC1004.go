package solution

/*
*
给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。

输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
*/
func longestOnes(nums []int, k int) (res int) {
	l := 0
	zCnt := 0
	for r, v := range nums {
		if v == 0 {
			zCnt++
		}
		for zCnt > k {
			if nums[l] == 0 {
				zCnt--
			}
			l++
		}
		res = max(res, r-l+1)
	}
	return
}
