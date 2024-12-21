from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def recursive_isSymmetric(self, root):
        if not None:
            return True
        if Solution.find_recurssive(root.left, root.right):
            return True
        return False
    
    def find_recurssive(left, right):
        if left == right == None :
            return True
        if left == None or right == None:
            return False
        return left.val == right.val and Solution.find_recurssively(left.left, right.right) and Solution.find_recurssively(left.right, right.left)

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        queue = []
        queue.append(root)
        while(len(queue) != 0):
            total_in_same_level = len(queue)
            i,j = 0, total_in_same_level-1
            while(i<=j):
                if queue[i] == queue[j] == None:
                    i+=1
                    j-=1
                    continue
                if queue[i] == None or queue[j] == None or queue[i].val != queue[j].val:
                    return False
                i+=1
                j-=1
            for index in range(0,total_in_same_level):
                element = queue.pop(0)
                if element != None:
                    queue.append(element.left)
                    queue.append(element.right)
                index+=1

        return True
    
    def createTree(self, array):
        if array == None or len(array)== 0:
            return None
        head = TreeNode(array.pop(0), None, None)
        queue = [head]
        while(len(queue)>0 and len(array) > 0):
            total= len(queue)
            for i in range(total):
                element = queue.pop(0)
                left = TreeNode(array.pop(0), None , None)
                right = TreeNode(array.pop(0), None , None) if len(array)>0 else None
                element.left = left
                element.right = right
                queue.append(left)
                queue.append(right)
        return head

solution = Solution()
root = solution.createTree([1,2,2,3,4,4,3, 2])
print(solution.isSymmetric(root))
print(solution.recursive_isSymmetric(root))