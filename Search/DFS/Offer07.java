/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i = 0;i < inorder.length;i++) {
			map.put(inorder[i],i);
		}
		return dfs(map,preorder,inorder,0,inorder.length - 1,0);
	}
	TreeNode dfs(HashMap<Integer,Integer> map,int[] preorder,int[] inorder,int left,int right,int rootIdx) {
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[rootIdx]);
		int idx = map.get(preorder[rootIdx]);
		root.left = dfs(map,preorder,inorder,left,idx - 1,rootIdx + 1);
		root.right = dfs(map,preorder,inorder,idx + 1,right,rootIdx + idx - left + 1);
		return root;
	}
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
