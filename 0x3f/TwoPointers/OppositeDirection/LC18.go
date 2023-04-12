package solution

import "sort"

/*
*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/
func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	n := len(nums)
	res := [][]int{}
	for i := 0; i < n-3; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < n-2; j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}
			k := j + 1
			m := n - 1
			for k < m {
				s := nums[i] + nums[j] + nums[k] + nums[m]
				if s == target {
					res = append(res, []int{nums[i], nums[j], nums[k], nums[m]})
					k++
					for k < m && nums[k] == nums[k-1] {
						k++
					}
					m--
					for k < m && nums[m] == nums[m+1] {
						m--
					}
				} else if s < target {
					k++
				} else {
					m--
				}
			}
		}
	}
	return res
}
