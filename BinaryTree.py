class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Node():
    def __init__(self, treeNode = None, next = None):
        if treeNode:
            self.val = treeNode.val
            self.left= treeNode.left
            self.right = treeNode.right
            self.next = next
    def  create_node_from_binary_Tree(self, root):
        if not root: 
            return root
        root = Node(root)
        queue = [root]    
        while(len(queue) != 0):
            for i in range(len(queue)):
                element = queue.pop(0)
                if element == None:
                    continue
                if element.left:
                    element.left = Node(element.left)
                    queue.append(element.left)
                if element.right:
                    element.right = Node(element.right)
                    queue.append(element.right)
        return root            

class BinaryTree:
    def create_tree_from_array(self, array):
        if len(array)==0:
            return None
        head = TreeNode(array.pop(0))
        queue=[head]
        while(len(array)>0 and len(queue)>0):
            pointer = queue.pop(0)
            if pointer == None:
                continue
            left = TreeNode(array.pop(0)) if array[0] != None else array.pop(0)
            if len(array) == 0:
                right = None
            else:
                right = TreeNode(array.pop(0)) if array[0] != None else array.pop(0)
            queue.extend([left, right])
            pointer.left = left
            pointer.right = right
        
        
        return head
        
