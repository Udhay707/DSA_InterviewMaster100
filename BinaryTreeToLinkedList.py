from typing import Optional
from BinaryTree import TreeNode, BinaryTree

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return
        tempSavedRight = root.right
        self.flatten(root.left)
        root.right = root.left
        root.left = None
        while(root.right != None):
            root = root.right
        root.right = tempSavedRight
        self.flatten(root.right)


solution = Solution()
root = BinaryTree().create_tree_from_array([1,2,5,3,4,None,6])
solution.flatten(root)
print(root.val)
while(root.right != None):
    print(root.left)
    print(root.right.val)
    root = root.right
