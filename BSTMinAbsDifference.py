from typing import Optional, List, Self
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
     def createTree(self, array: List) -> Self:
        if len(array) == 0:
             return None
        head = TreeNode(array.pop(0))
        queue = [head]

        while(len(array) > 0 and len(queue)>0):
             pointer = queue.pop(0)
             if not pointer:
                  continue
             leftNode = TreeNode(array.pop(0)) if array[0] != None else array.pop(0)
             rightNode = TreeNode(array.pop(0)) if len(array) > 0 and array[0] != None else array.pop(0)

             queue.extend([leftNode, rightNode])
             pointer.left = leftNode
             pointer.right = rightNode
        return head

class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        array = []
        self.getSortedArray(root, array)
        minDifference = float("inf")
        prev = float("inf")
        for num in array:
            minDifference = min(minDifference, abs(prev - num))
            prev = num
        return minDifference

    def getSortedArray(self, node: Optional[TreeNode], array: List):
        if not node:
            return
        self.getSortedArray(node.right, array)
        array.append(node.val)
        self.getSortedArray(node.left, array)


head = TreeNode().createTree([543,384,652,None,445,None,699])
sol = Solution()
print(sol.getMinimumDifference(head))