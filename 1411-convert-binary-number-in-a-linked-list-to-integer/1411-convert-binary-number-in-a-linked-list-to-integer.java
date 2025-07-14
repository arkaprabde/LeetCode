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
class Solution {
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int c = 1, n = 0;
        for (ListNode t = head; t != null; t = t.next) c *= 2;

        for (ListNode t = head; t != null; t = t.next, c /= 2) n += t.val * c;
        return n / 2;
    }
}