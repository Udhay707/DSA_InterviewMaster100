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
             leftNode = TreeNode(array.pop(0)) if array[0] != None else None
             rightNode = TreeNode(array.pop(0)) if len(array) > 0 and array[0] != None else None

             queue.extend([leftNode, rightNode])
             pointer.left = leftNode
             pointer.right = rightNode
        return head
     
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:   
        if root == None and targetSum != 0:
            return False
        if root == None and targetSum == 0:
            return True
        if targetSum < 0:
            return False
        return self.hasPathSum(root.left, targetSum - root.val) or self.hasPathSum(root.right, targetSum - root.val)



             
head = TreeNode().createTree([1,2,3])
sol = Solution().hasPathSum(head, 5)
print(sol)