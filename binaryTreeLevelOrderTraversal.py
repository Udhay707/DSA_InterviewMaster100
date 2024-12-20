# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        queue = []
        ans = []
        queue.append(root)
        while(len(queue) > 0):
            level = []
            for i in range(0, len(queue)):
                poped = queue.pop(0)
                level.append(poped.val)
                if poped.left != None:
                    queue.append(poped.left)
                if poped.right != None:
                    queue.append(poped.right)    
            ans.append(level)
        return ans