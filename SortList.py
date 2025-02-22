# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
from typing import Optional
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def getMid(head):
            fast = head.next
            slow = head
            while(fast != None and fast.next != None):
                slow = slow.next
                fast = fast.next.next
            return slow

        if not head or not head.next:
            return head
        
        left = head
        mid = getMid(head)
        right = mid.next
        mid.next = None

        firstNode = self.sortList(left)
        secondNode = self.sortList(right)

        return self.merge(firstNode, secondNode)
    
    def merge(self, node1: Optional[ListNode], node2: Optional[ListNode]) -> ListNode:
            mergedNode: ListNode = ListNode()
            temp: ListNode = mergedNode

            while(node1 and node2):
                if(node1.val < node2.val):
                    temp.next = node1
                    node1 = node1.next
                else:
                    temp.next = node2
                    node2 = node2.next
                temp = temp.next

            while(node1):
                temp.next = node1
                node1 = node1.next
                temp = temp.next
            
            while(node2):
                temp.next = node2
                node2 = node2.next
                temp = temp.next
            
            return mergedNode.next