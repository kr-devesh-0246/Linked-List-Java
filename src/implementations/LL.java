package implementations;

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
    // insert using recursion
    public void insertRec(int val, int index) {
        // helper
        head = insertRec(val, index, head);
    }
    public Node insertRec(int val, int index, Node node) { // node initialized with head
        // base case
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }
    /* Mine was throwing NPExceptions
        public void insertRec(int val, int index) {
        if (head == null) {
            System.out.println("list empty");
            // addFirst();
        }
        Node node = new Node(val);
        Node temp = getNodeRec(val, head);
        node.next = temp.next;
        temp.next = node;

    }
    public Node getNodeRec(int val, Node node) {
        if (node == null) { // do testing
            System.out.println("DNE");
            return;
        }
        if (node.next != null && node.next.val == val) {
            return node;
        }
        return getNodeRec(val, node.next);

    }*/
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

/*
    // Interview Questions: timestamp 1:38 on youtube
    private void bubbleSort(int row, int col) {
    }*/

    // reverse LL using recusion
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
}
