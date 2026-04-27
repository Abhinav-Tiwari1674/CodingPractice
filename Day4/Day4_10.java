public class Day4_10 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode second = slow.next;
        slow.next = null; // Split the list
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        ListNode secondHead = prev;

        // Merge the two halves
        ListNode first = head;
        ListNode secondCurrent = secondHead;
        while (secondCurrent != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = secondCurrent.next;

            first.next = secondCurrent;
            secondCurrent.next = temp1;

            first = temp1;
            secondCurrent = temp2;
        }
    }

}
