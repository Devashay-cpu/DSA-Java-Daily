import java.util.HashMap;

class LC138_CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create copy nodes and insert them after original nodes
        Node current = head;

        while (current != null) {
            Node copy = new Node(current.val);

            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        // Step 2: Assign random pointers
        current = head;

        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Step 3: Separate original and copied lists
        Node dummy = new Node(0);
        Node copyCurrent = dummy;
        current = head;

        while (current != null) {
            Node copy = current.next;

            current.next = copy.next;
            copyCurrent.next = copy;
            copyCurrent = copy;

            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            int randomValue =
                    head.random != null ? head.random.val : -1;

            System.out.println(
                    "Node: " + head.val +
                    ", Random: " + randomValue
            );

            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        Node copiedList = copyRandomList(node1);

        printList(copiedList);
    }
}