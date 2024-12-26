from typing import List, Optional
from BinaryTree import TreeNode, BinaryTree

class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        if root.left == None and root.right == None:
            return [[root.val]]
        queue = [root]
        return_list = []
        level=0
        while(len(queue) != 0):
            currentList = []
            length  = len(queue)
            for i in range(0, length):
                if level%2 ==  0:
                    element = queue.pop(0)
                    if element.left != None:
                        queue.append(element.left)
                    if element.right != None:
                        queue.append(element.right)
                else:
                    element = queue.pop()
                    if element.right != None:
                        queue.insert(0,element.right)
                    if element.left != None:
                        queue.insert(0,element.left)
                currentList.append(element.val)  
            return_list.append(currentList)
            level += 1         
            
        return return_list  

sol = Solution()
binary_tree = BinaryTree().create_tree_from_array([1,2,3,4,None,None,5]) 
result = sol.zigzagLevelOrder(binary_tree)
print(result)