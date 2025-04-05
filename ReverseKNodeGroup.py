# Definition for singly-linked list.
from ast import List
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:

        def findKthNode(k, node):
            while(k>1 and node):
                node = node.next
                k-=1
            return node
        def reverse(start, end, prev):
            last = None
            while(start != end):
                next = start.next
                start.next = last
                last = start
                start = next
            prev.next = last

        current = head
        dummy = ListNode()
        dummy.next = head
        prev = dummy
        while current:
            kthNode = findKthNode(k, current)
            if not kthNode:
                prev.next = current
                return dummy.next
            nextNode = kthNode.next
            reverse(current, nextNode, prev)
            prev = current
            current = nextNode

        return dummy.next




def printll(node):
    while(node):
        print(node.val)
        node = node.next
sol = Solution()

dummy = ListNode()
current = dummy
temp = None
for i in range(1, 6):
    current.next = ListNode(i)
    current = current.next
rev = sol.reverseKGroup(dummy.next, 2)
printll(rev)
