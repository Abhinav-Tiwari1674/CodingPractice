

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Day4_4 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head; // Connect the tail to the head to form a circle
        k = k % length; // Handle cases where k is greater than length
        for (int i = 0; i < length - k; i++) {
            tail = tail.next; // Move to the new tail
        }
        ListNode newHead = tail.next; // The new head is the next node after the new tail
        tail.next = null; // Break the circle
        return newHead;
    }
}