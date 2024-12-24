from typing import Optional
from BinaryTree import TreeNode, BinaryTree

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isValid(root, None, None)

    def isValid(self, node, greaterThan, lesserThan):
        if node == None:
            return True
        
        if greaterThan != None and node.val <= greaterThan:
            return False
        
        if lesserThan is not None and node.val >= lesserThan:
            return False
        
        return self.isValid(node.left, greaterThan, node.val) and self.isValid(node.right, node.val, lesserThan)


        

if __name__ == "__main__":
    sol = Solution()
    binaryTree = BinaryTree().create_tree_from_array([2,2,2])
    print(sol.isValidBST(binaryTree))