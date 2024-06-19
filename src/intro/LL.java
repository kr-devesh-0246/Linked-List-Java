package intro;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    private static class Node {
        private int val;
        private Node next;
        private final Node head = null;
        private final Node tail = null;

        public Node() {
            int size = 0;
        }
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // methods
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) { // first item being added
            tail = head;
        }
        size++;
    }
    public void insertLast(int val) {
        Node node = new Node(val);
        // if empty
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        while (temp != null) {
            tail = temp;
            temp = temp.next;
        }
        tail.next = node;
        tail = node;
        size++;
    }
    public void insertAt(int val, int index) {
        if (index == 0) {
            insertFirst(val);
        } else if (index == this.size - 1) {
            insertLast(val);
        } else {
            Node temp = head;
            for (int i = 0; i <= index-2; i++) {
                temp = temp.next;
            }
            temp.next = new Node(val, temp.next);
            size++;
        }
    }
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = getNodeByIndex(index - 1); // can delete using value too. 
        int val = prev.next.val;
        prev.next = prev.next.next;

        return val;
    }

    public int deleteFirst() {
        int val = head.val;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return val;
    }
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getNodeByIndex(size - 2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    public Node getNodeByIndex(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value)
                return node;
            node = node.next;
        }
        return null;
    }
    public Node getNodeByValue  (int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
