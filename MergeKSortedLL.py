from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None
        return self.splitAndMerge(lists, 0, len(lists)-1)
    
    def splitAndMerge(self, lists, start, end) -> ListNode:
        if start == end:
            return lists[start]
        mid = start + (end-start)//2
        left = self.splitAndMerge(lists, start, mid)
        right = self.splitAndMerge(lists, mid+1, end)
        return self.merge(left, right)

    def merge(self, left, right):
        head = ListNode()
        dummy = head

        while(left and right):
            if left.val < right.val:
                dummy.next = left
                left = left.next
            else:
                dummy.next = right
                right = right.next
            dummy = dummy.next
        while left:
            dummy.next = left
            left = left.next
            dummy = dummy.next
        while right:
            dummy.next = right
            right = right.next
            dummy = dummy.next
        return head.next
    
sol = Solution()

ll = []

numbers = [[1,4,5],[1,3,4],[2,6]]

for k in numbers:
    l = ListNode()
    temp = l
    for j in k:
        l.next = ListNode(j)
        l= l.next
    ll.append(temp.next)

result = sol.mergeKLists(ll)

while(result):
    print(result.val)
    result = result.next