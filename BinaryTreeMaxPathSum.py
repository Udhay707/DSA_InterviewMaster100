from typing import Optional
from BinaryTree import TreeNode, BinaryTree

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxSum = -float("inf")
        self.findDia(root)
        return self.maxSum

    def findDia(self, node):
        if not node:
            return 0
        
        left = max(0, self.findDia(node.left))
        right = max(0, self.findDia(node.right))

        self.maxSum = max(self.maxSum, left + right + node.val)

        return node.val + max(left, right)


root = BinaryTree().create_tree_from_array([-3, -2, -1, 10, -2, -4])
sol = Solution().maxPathSum(root)
print(sol)