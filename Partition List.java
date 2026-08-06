/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes to maintain the start of both lists
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        // Pointers to track the current tail of both lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        // Traverse the original list
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        
        // Crucial step: cut off any remaining nodes to prevent a cycle
        greater.next = null;
        
        // Connect the 'less' list with the 'greater' list
        less.next = greaterHead.next;
        
        // Return the head of the newly partitioned list
        return lessHead.next;
    }
}
