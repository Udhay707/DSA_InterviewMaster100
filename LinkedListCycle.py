from typing import List, Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None 
        
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        def eval_fast_pointer(fast_pointer):
            return fast_pointer is None or fast_pointer.next is None
        slow_pointer = fast_pointer = head
        if(eval_fast_pointer(fast_pointer)):
            return False
        fast_pointer = head.next.next
        while(slow_pointer != fast_pointer):
            slow_pointer =  slow_pointer.next
            if eval_fast_pointer(fast_pointer):
                return False
            fast_pointer = fast_pointer.next.next
        return True 
    
   





