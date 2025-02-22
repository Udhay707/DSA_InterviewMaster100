var diameterOfBinaryTree = function(root) {
    let maxDia = 0;
    function findDia(head){
        if(head.left == null && head.right == null){
            return 0;
        }
        let leftDia = head.left != null ? findDia(head.left) + 1 : 0;
        let rightDia = head.right != null ? findDia(head.right) + 1 : 0;

        if(leftDia + rightDia > maxDia){
            maxDia = leftDia + rightDia;
        }
        return Math.max(leftDia, rightDia);
    }
    findDia(root);
    return maxDia;
    
};

function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}


let right = new TreeNode(3, null, new TreeNode(4 , null, null));
let left = new TreeNode(2 , new TreeNode(5, null, null), null);
let root = new TreeNode( 1, left, right);


console.log(diameterOfBinaryTree(root))
