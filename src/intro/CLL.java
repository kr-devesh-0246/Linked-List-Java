package intro;

public class CLL {
    private Node head;
    private Node tail;
    private int size;
    public CLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /*public CLL(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        this.size = 0;
    }*/

    private class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public void insert(int val) { // only type of insertion is at end. Is it true?
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        // LL is not empty
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }
    public void delete(int val) {
        if (head == null) { // for no nodes
            System.out.println("does not exist");
            return;
        }
        Node node = head;
        // assuming head is the target node itself
        if (node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        // otherwise, start checking for next items
        do {
            Node n = node.next;
            if (n.val == val) { // target found
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }
    public void display() { // think sharply
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
    }
}
