package implementations;

public class DLL {
    private Node head;
    private Node tail;
    private int size;
    public DLL() {
        this.size = 0;
    }
    public static class Node {
        private int val;
        private Node next = null    ; // defalut = null
        private Node prev = null;
        public Node() { // perhaps useless
            int size = 0;
        }
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }
    public void insertFirst(int val) { // mine
        Node node = new Node(val);
        if (tail == null) {
            tail = node;
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }
    public void insertFirstKK(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null; // perhaps redundant
        if (head != null) { // to prevent NPE
            head.prev = null;
        }
        head = node;
        size++;
    }
    public void insertLast(int val) {
        Node node = new Node(val);
        if (tail == null) {
            insertFirst(val);
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }
    public void insertLastKK(int val) { // without using tail
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
        size++;
    }
    public Node getNode(int val) {
        Node node = head;
        while (node.val != val) {
            if (node.val == val){
                return node;
                }
            node = node.next;
        }
        return null;
    }
    public void insertAfter(int after, int val) {
        Node p = getNode(after);
        if (p == null) {
            System.out.println("does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null)
            node.next.prev = node;

    }
    public void display() {
        Node temp = head;
        System.out.print("Null");
        while (temp != null) {
            System.out.print(" <- -> " + temp.val + " <- -> ");
            temp = temp.next;
        }
        System.out.print("Null");
    }
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public void displayBackward() {
        Node temp = tail;
        System.out.print("Null");
        while (temp != null) {
            System.out.print(" <- " + temp.val);
            temp = temp.prev;
        }
    }
}
