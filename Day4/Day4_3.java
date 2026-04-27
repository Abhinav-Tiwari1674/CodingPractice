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

public class Day4_3 {

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newHead = head.next;
            ListNode prev = null, current = head;
            while (current != null && current.next != null) {
                ListNode nextPair = current.next.next;
                ListNode second = current.next;
    
                // Swap the pair
                second.next = current;
                current.next = nextPair;
    
                // Connect the previous pair with the current pair
                if (prev != null) {
                    prev.next = second;
                }
    
                // Move to the next pair
                prev = current;
                current = nextPair;
            }
            return newHead;
        }


    
}
