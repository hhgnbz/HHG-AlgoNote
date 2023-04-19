package solution

/*
*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
*/
func trap(height []int) (res int) {
	n := len(height)
	pre := 0
	suf := 0
	l := 0
	r := n - 1
	for l < r {
		pre = max(pre, height[l])
		suf = max(suf, height[r])
		if pre < suf {
			res += pre - height[l]
			l++
		} else {
			res += suf - height[r]
			r--
		}
	}
	return
}
