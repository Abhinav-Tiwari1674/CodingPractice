class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummy = new Node(0, null, head, null);
        Node curr = dummy;
        Node prev = dummy;

        while (curr != null) {
            if (curr.child != null) {
                // Find the tail of the child list
                Node childTail = curr.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                // Connect child list
                childTail.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = childTail;
                }

                // Connect current to child
                curr.next = curr.child;
                curr.child.prev = curr;

                // Remove child pointer
                curr.child = null;
            }

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}