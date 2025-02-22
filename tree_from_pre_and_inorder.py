from typing import List, Optional, Dict
from BinaryTree import TreeNode
class Solution:
    """
    hashmaps to optimize the index query to inorder
    understand how inorder traversal works
    understand how preorder traversal works
    understanding of binary search
    solution is possible only because the tree contains only unique value
    """
    def __init__(self):
        self.positionMap: Dict = {}
        self.preOrderIndex = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(0,len(inorder)):
            self.positionMap[inorder[i]] = i
        return self.prepareTree(preorder, inorder, 0, len(inorder)-1)    
    def prepareTree(self, preorder: List[int], inorder: List[int], leftIndex : int, rightIndex : int) -> Optional[TreeNode]:
        data = preorder[self.preOrderIndex]
        root = TreeNode(data)
        self.preOrderIndex+=1
        index = self.positionMap[data]
        if index > leftIndex:
            root.left = self.prepareTree(preorder, inorder, leftIndex, index-1)
        if index < rightIndex:
            root.right = self.prepareTree(preorder, inorder, index+1, rightIndex) 
        return root  
    
solution = Solution().buildTree(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7])
print(solution)