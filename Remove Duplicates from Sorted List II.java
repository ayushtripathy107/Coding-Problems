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
    public ListNode deleteDuplicates(ListNode head) {
        // Sentinel/dummy node points to the head of the list
        ListNode dummy = new ListNode(0, head);
        
        // 'prev' is the last node known to have no duplicates
        ListNode prev = dummy;
        
        while (head != null) {
            // Check if it's the start of a duplicate sublist
            if (head.next != null && head.val == head.next.val) {
                // Move 'head' forward until we reach the last node of the duplicates
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip all duplicates by linking 'prev' directly to the node after 'head'
                prev.next = head.next;
            } else {
                // No duplicate detected, safe to advance 'prev'
                prev = prev.next;
            }
            // Move forward in the list
            head = head.next;
        }
        
        return dummy.next;
    }
}
