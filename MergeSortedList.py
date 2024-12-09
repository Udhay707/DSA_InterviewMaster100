from typing import Optional, List
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()
        pointer = result

        while(list1 != None and list2 != None ):
            if list1.val < list2.val:
                pointer.next = ListNode(list1.val, None)
                list1 = list1.next
            else:
                pointer.next = ListNode(list2.val, None)
                list2 = list2.next
            pointer=pointer.next

        if(list1 != None):
            pointer.next = list1
        elif(list2 != None):
            pointer.next = list2
        return result.next

def createLL(nums: List) -> Optional[ListNode]:
    head = ListNode()
    pointer = head
    for num in nums:
        pointer.next = ListNode(num, None)
        pointer = pointer.next
    return head.next

def printLL(nums: Optional[ListNode]):
    while(nums != None):
        print(nums.val, end=" ")
        nums = nums.next    
    print()

list1 = createLL([1,2,4])  
list2 = createLL([1,2,4])   
sol = Solution().mergeTwoLists(list1,list2)
printLL(sol)
