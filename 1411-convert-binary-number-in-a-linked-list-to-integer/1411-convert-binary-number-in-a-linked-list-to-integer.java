class Solution {
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int c = 1, n = 0;
        for (ListNode t = head; t != null; t = t.next) c *= 2;

        for (ListNode t = head; t != null; t = t.next, c /= 2) n += t.val * c;
        return n / 2;
    }
}