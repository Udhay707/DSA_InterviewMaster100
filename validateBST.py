from BinaryTree import TreeNode, BinaryTree
from typing import Optional

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def isValid(node, min, max):
            if not node:
                return True
            if not (node.val > min and node.val < max):
                return False
            return isValid(node.left, min, node.val) and isValid(node.right, node.val, max)
        return isValid(root, -float("inf"), float("inf"))
            
        
    
sol = Solution()
root = BinaryTree.BinaryTree().create_tree_from_array([5,4,6,None,None,3,7])
print(sol.isValidBST(root))