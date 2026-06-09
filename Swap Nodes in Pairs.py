class Solution(object):
    def swapPairs(self, head):
        # Create a dummy node to simplify edge cases (like swapping the head)
        dummy = ListNode(0)
        dummy.next = head
        current = dummy
        
        while current.next and current.next.next:
            # Nodes to be swapped
            first = current.next
            second = current.next.next
            
            # Swapping
            first.next = second.next
            second.next = first
            current.next = second
            
            # Move pointer forward by two nodes
            current = first
            
        return dummy.next
