from typing import List, Optional
from BinaryTree import TreeNode, BinaryTree

class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        if root.left == None and root.right == None:
            return [[root.val]]
        returnList = self.find_bottom_and_return([root])
        returnList.append([root.val])
        return returnList
        


    def find_bottom_and_return(self, queue: List[TreeNode]) -> List[List]:
        if(len(queue) == 0):
            return []
        newQueue = []
        for i in range(0, len(queue)):
            if queue[i].left != None:
                newQueue.append(queue[i].left)

            if queue[i].right != None:
                newQueue.append(queue[i].right)
        bottom = self.find_bottom_and_return(newQueue)
        if len(newQueue) == 0:
            return bottom
        newQueue = list(map(lambda element : element.val, newQueue))
        bottom.append(newQueue)
        return bottom
              
    

bt = BinaryTree()
root = bt.create_tree_from_array([3,9,20,None,None,15,7])
reverse_level_order = Solution().levelOrderBottom(root)
print(reverse_level_order)