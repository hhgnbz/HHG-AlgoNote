/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		// 辅助结点
		ListNode dummy = new ListNode(-1,head);
		// 反转前最后一个结点
		ListNode temp = dummy;
		// 反转开始结点
		ListNode cur = dummy.next;
		// 移动到反转开始
		for (int i = 1;i < left;i++) {
			temp = temp.next;
			cur = cur.next;
		}
		ListNode pre = null;
		for (int i = left;i < right;i++) {
			// 原指向的下一个结点
			ListNode next = cur.next;
			// 两两交换位置,需要注意temp是不动的
			cur.next = cur.next.next;
			next.next = temp.next;
			temp.next = next;
		}
		return dummy.next;
	}
}
