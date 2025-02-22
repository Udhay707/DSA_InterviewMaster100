from typing import Optional, List
from BinaryTree import TreeNode, BinaryTree

class Solution:

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return -1
        stack = []
        self.addLeftItemsToStack(root, stack)
        n = 0
        while(len(stack) != 0):
            element = stack.pop()
            if element != None:
                n+=1
                # print(f"{element.val} -> {n}")
            if n == k:
                return element.val
            self.addLeftItemsToStack(element.right, stack)
        return -1
    def addLeftItemsToStack(self, node: Optional[TreeNode], stack: List):
        while(node != None):
            stack.append(node)
            node = node.left    

root = BinaryTree().create_tree_from_array([5,3, 7, 1,4, 6, 9])      
solution = Solution().kthSmallest(root, 4)
print(solution)

        

        

        

    
