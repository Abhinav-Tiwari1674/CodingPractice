

public class Day3_5 {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; // Cannot delete if null or last node
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}