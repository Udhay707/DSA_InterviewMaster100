class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BinaryTree:
    def create_tree_from_array(self, array):
        if len(array)==0:
            return None
        head = TreeNode(array.pop(0))
        queue=[head]
        while(len(array)>0 and len(queue)>0):
            pointer = queue.pop()
            if pointer == None:
                continue
            left = TreeNode(array.pop(0)) if array[0] != None else array.pop(0)
            if len(array) == 0:
                right = None
            else:
                right = TreeNode(array.pop(0)) if array[0] != None else array.pop(0)
            queue.extend([right, left])
            pointer.left = left
            pointer.right = right
        
        
        return head
        
