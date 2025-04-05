from BinaryTree import BinaryTree, TreeNode

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > q.val:
            return self.lowestCommonAncestor(root, q, p)
        while root:
            if(root.val >= p.val and root.val <= q.val):
                return root
            if root.val > p.val and root.val > q.val:
                root = root.left
            else:
                root = root.right
        return root 
           
root = [6,2,8,0,4,7,9,None,None,3,5]

root = BinaryTree().create_tree_from_array(root)
sol = Solution().lowestCommonAncestor(root, root.left, root.right)
print(sol.val)