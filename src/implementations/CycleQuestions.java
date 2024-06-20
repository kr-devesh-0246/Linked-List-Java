package implementations;

public class CycleQuestions {
    // https://leetcode.com/problems/linked-list-cycle
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public int lengthOfCycle(ListNode head) {
        int count = 0; // better placing of count
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode temp = slow;
                while (temp != fast) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }

        }
        return 0; // return 0 as no cycle
    }

     //Definition for singly-linked list.
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
