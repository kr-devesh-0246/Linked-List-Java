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

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                length = lengthOfCycle(slow);
                break;
            }
        }
        // find the start node
        ListNode first = head;
        ListNode second = head;
          // move the first by length of the cycle times
        while (length > 0) {
            second = second.next;
            length--;
        }
        /*for (int i = 0; i < length; i++) {
            second = second.next;
        }*/
          // keep moving both forward and they will meet at cycle start
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        // return any one node
        return first;
    }

    // https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        if (slow == 1)
            return true;
        return false;
    }
    private int findSquare(int n) {
        int ans = 0;
        int rem;
        while (n > 0) {
            rem = n %10;
            ans += rem * rem;
            n = n/10;
        }
        return ans;
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
