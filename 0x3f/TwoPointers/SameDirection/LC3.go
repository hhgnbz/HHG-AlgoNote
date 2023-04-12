package solution

/*
*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*/
func lengthOfLongestSubstring(s string) (res int) {
	l := 0
	check := map[byte]int{}
	for r := 0; r < len(s); r++ {
		check[s[r]]++
		for check[s[r]] > 1 {
			check[s[l]]--
			l++
		}
		res = max(res, r-l+1)
	}
	return
}
