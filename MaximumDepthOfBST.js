function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}
// Actual Solution

let maxDepth = function(root) {
    let maxDepth = 0;

    function iterate(root, depth){
        if(root == null)
            return;
        
        iterate(root.left, depth+1);
        iterate(root.right, depth+1);
        maxDepth = depth > maxDepth ? depth : maxDepth;
    }
    iterate(root, 1);
    return maxDepth; 
};

// Solution Ends
let insertToBst = (array, rootNode, position) =>{
    if(position == array.length || rootNode.val == null){
        return
    }
    let isGreater = array[position] > rootNode.val 
    
    if(isGreater && rootNode.right == null)
        return rootNode.right = new TreeNode(array[position], null, null)    
     else if(!isGreater && rootNode.left == null)
        return rootNode.left = new TreeNode(array[position], null, null)       
    
    isGreater ? insertToBst(array, rootNode.right, position) : insertToBst(array, rootNode.right, position)

}


let array = [3,9,20,15,7]

let rootNode = new TreeNode(array[0], null, null);

for(let i=1; i<array.length; i++){
    insertToBst(array, rootNode, i);
}

console.log(maxDepth(rootNode));