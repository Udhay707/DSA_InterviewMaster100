from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        numIndexMap = {v:i for i,v in enumerate(inorder)}
        return self._buildTree(inorder, postorder, 0, len(inorder)-1, numIndexMap)
    
    def _buildTree(self,  inorder: List[int], postorder: List[int], inorderStartIndex: int, inorderEndIndex: int, numsIndexMap: dict) -> Optional[TreeNode]:
        if inorderStartIndex > inorderEndIndex:
            return None
        val = postorder.pop()
        head = TreeNode(val)
        index = numsIndexMap[val]
        head.right = self._buildTree(inorder,postorder, index + 1, inorderEndIndex, numsIndexMap)
        head.left = self._buildTree(inorder, postorder, inorderStartIndex, index-1, numsIndexMap)
        return head


sol = Solution()
root = sol.buildTree(inorder = [9,3,15,20,7], postorder = [9,15,7,20,3])
print(root)