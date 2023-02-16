/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2) -> n1.val - n2.val);
		for (ListNode l : lists) {
			while (l != null) {
				pq.add(new ListNode(l.val));
				l = l.next;
			}
		}
		ListNode res = new ListNode(-1);
		ListNode temp = res;
		while (!pq.isEmpty()) {
			temp.next = pq.poll();
			temp = temp.next;
		}
		return res.next;
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
