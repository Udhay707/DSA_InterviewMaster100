from typing import Optional
from BinaryTree import TreeNode, BinaryTree


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Trick used is forcefully adding a None as a separator between children of same parents
        """
        if not root:
            return False
        queue =  [root]
        while(len(queue) != 0):
            xx, yy = (-1, -1)
            length = len(queue)
            for i in range(0, length):
                element = queue[i]
                if not element:
                    continue
                if element.val == x:
                    xx = i
                if element.val == y:
                    yy = i
                queue.append(element.left)
                queue.append(element.right)
                queue.append(None) #trick
            queue = queue[length:]
            if xx != -1 and yy != -1 and xx+1 != yy and yy+1 != xx:
                return True
        return False

solution = Solution()
root = BinaryTree().create_tree_from_array([10,1,2,3,4,5,6])
is_cousin = solution.isCousins(root, 4, 5)
print(is_cousin)
        