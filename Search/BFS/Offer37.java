/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		// 注意需要存放null值,用LinkedList而非ArrayDeque
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				sb.append(node.val + ",");
				q.add(node.left);
				q.add(node.right);
			} else {
				sb.append("null,");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("[]")) {
			return null;
		}
		String[] vals = data.substring(1,data.length() - 1).split(",");
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int idx = 1;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (!vals[idx].equals("null")) {
				TreeNode left = new TreeNode(Integer.parseInt(vals[idx]));
				node.left = left;
				q.add(left);
			}
			idx++;
			if (!vals[idx].equals("null")) {
				TreeNode right = new TreeNode(Integer.parseInt(vals[idx]));
				node.right = right;
				q.add(right);
			}
			idx++;
		}
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
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
