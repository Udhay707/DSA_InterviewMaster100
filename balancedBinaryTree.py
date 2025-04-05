from typing import Optional

from BinaryTree import BinaryTree, TreeNode


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def getHeight(node):
            if not node:
                return 0
            left = getHeight(node.left)
            if left == -1:
                return -1
            right = getHeight(node.right)
            if right == -1:
                return -1
            if abs(right - left)>1:
                return -1
            return max(right, left)+1
        return getHeight(root) != -1


tree = BinaryTree().create_tree_from_array([3,9,20,None,None,15,7])
print(Solution().isBalanced(tree))