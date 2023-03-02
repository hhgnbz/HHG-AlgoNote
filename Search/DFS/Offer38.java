/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
class Solution {
	public String[] permutation(String s) {
		char[] sc = s.toCharArray();
		// set去重
		HashSet<String> resList = new HashSet<>();
		boolean[] used = new boolean[sc.length];
		StringBuilder sb = new StringBuilder();
		dfs(sc,resList,used,sb);
		return resList.toArray(new String[0]);
	}
	void dfs(char[] sc,HashSet<String> resList,boolean[] used,StringBuilder sb) {
		if (sb.length() == sc.length) {
			resList.add(sb.toString());
			return;
		}
		for (int i = 0;i < sc.length;i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			sb.append(sc[i]);
			dfs(sc,resList,used,sb);
			used[i] = false;
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
