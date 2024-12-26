from typing import Optional
from BinaryTree import Node, BinaryTree

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        queue = [root]
        while(len(queue) != 0):
            length = len(queue)
            while(length >= 1):
                element = queue.pop(0)
                length -= 1
                if element == None:
                    continue
                if length >= 1:
                    element.next = queue[0]
                if element.left:
                    queue.append(element.left)
                if element.right:
                    queue.append(element.right)
                 
        return root


solution = Solution()
root = BinaryTree().create_tree_from_array([1,2,3,4,5,6,7])
root = Node().create_node_from_binary_Tree(root)
solution.connect(root)