package BinarySearch

/**
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
*/

func searchRange(nums []int, target int) []int {
	rIdx := binarySearch(nums, target)
	lIdx := binarySearch(nums, target-1)
	if rIdx-lIdx < 1 {
		return []int{-1, -1}
	}
	return []int{lIdx, rIdx - 1}
}
func binarySearch(nums []int, target int) int {
	l := 0
	r := len(nums)
	for l < r {
		m := l + (r-l)/2
		if nums[m] <= target {
			l = m + 1
		} else {
			r = m
		}
	}
	return r
}
