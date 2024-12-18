from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        return self.insertIntoTree(0, len(nums), nums)
    
    def insertIntoTree(self, leftIndex, rightIndex, array):
        if leftIndex >= rightIndex:
            return None
        mid = (leftIndex + rightIndex)//2
        return TreeNode(array[mid], 
                        self.insertIntoTree(leftIndex, mid, array),
                        self.insertIntoTree(mid+1, rightIndex, array))

def printBst(node):
    if node == None:
        return
    print(f"{node.val}", end = ", ")
    printBst(node.left)
    printBst(node.right)

root = Solution().sortedArrayToBST([0, 1, 2, 3, 4])    
printBst(root)