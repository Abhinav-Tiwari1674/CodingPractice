public class Day4_12 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int duplicateVal = current.next.val;
                while (current.next != null && current.next.val == duplicateVal) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

}
