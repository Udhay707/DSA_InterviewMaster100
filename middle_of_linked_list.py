from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Constraints:

# The number of nodes in the list is in the range [1, 100].
# 1 <= Node.val <= 100


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fastPointer = head
        
        while(fastPointer != None and fastPointer.next != None):
            head = head.next
            fastPointer = fastPointer.next.next

        return head


def insertIntoLL(head, array):
    for i in array:
        head.next = ListNode(i)
        head = head.next

def printLL(node):
    while(node != None):
        print(node.val)
        node = node.next

head = ListNode()
insertIntoLL(head,[1,1,2])   
k = Solution().middleNode(head.next)
printLL(k)