# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        if(not head.next):
            return None
        dummy = ListNode()
        dummy.next = head
        pointer1 = pointer2 = dummy

        for _ in range(0, n+1):
            pointer2 = pointer2.next
        
        while(pointer2):
            pointer1 = pointer1.next
            pointer2 = pointer2.next
        pointer1.next = pointer1.next.next

        return dummy.next    



def createLL(array):
    head = ListNode(array[0])
    temp = head
    for i in array:
        temp.next = ListNode(i)
        temp = temp.next
    return head.next

def printLL(linkedList):
    while(linkedList != None):
        print(linkedList.val, end=" ")
        linkedList = linkedList.next

ll = createLL([1,2]);
solution = Solution().removeNthFromEnd(ll, 1)
printLL(solution)