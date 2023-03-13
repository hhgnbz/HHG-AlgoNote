/**
 * 给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，所以 parent[0] == -1 。
 *
 * 另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。
 *
 * 请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。
 *
 * 输入：parent = [-1,0,0,1,1,2], s = "abacbe"
 * 输出：3
 * 解释：任意一对相邻节点字符都不同的最长路径是：0 -> 1 -> 3 。该路径的长度是 3 ，所以返回 3 。
 * 可以证明不存在满足上述条件且比 3 更长的路径。
 */
class Solution {
    int res = 0;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g,e -> new ArrayList<>());
        for (int i = 1;i < n;i++) {
            g[parent[i]].add(i);
        }
        dfs(g,s,0);
        return res + 1;
    }
    int dfs(List<Integer>[] g, String s, int depth) {
        int maxLen = 0;
        for (int x : g[depth]) {
            int len = dfs(g,s,x) + 1;
            if (s.charAt(x) != s.charAt(depth)) {
                res = Math.max(res,maxLen + len);
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}