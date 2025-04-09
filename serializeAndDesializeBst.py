from BinaryTree import TreeNode, BinaryTree

class Codec:

    def serialize(self, root):
        if not root:
            return "|"
        separator = "*"
        queue = [root]
        serialize = ""
        while queue:
            length = len(queue)
            for i in range(length):
                node = queue.pop(0)
                if not node:
                    serialize += "|"+separator
                    continue
                serialize += str(node.val)+separator
                queue += node.left, node.right
        return serialize
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "|" or len(data)==0:
            return None
        index = 0
        number, index = self.getNextNum(index, data)
        root = TreeNode(number)
        queue = [root]
        while queue:
            node = queue.pop(0)
            if not node:
                continue
            number, index = self.getNextNum(index, data)
            node.left = TreeNode(number) if number != None else None
            number, index = self.getNextNum(index, data)
            node.right = TreeNode(number) if number!= None else None
            queue += node.left, node.right
        return root

    def getNextNum(self, index, data):
        separator = "*"
        number = ""
        while(index < len(data) and data[index] != separator):
            number += data[index]
            index+=1
        if number == "|" or number == "":
            return None, index+1
        return int(number), index+1



root = BinaryTree().create_tree_from_array([1,2,3,None,None,4,5])
codec = Codec()
ser = codec.serialize(root)
print(ser)
deser = codec.deserialize(ser)
print(deser)