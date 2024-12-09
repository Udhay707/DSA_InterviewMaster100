var invertTree = function(root) {
    if(root==null){
        return root;
    }
    if(root.left == null && root.right == null){
        return root;
    }
    if(root.left != null)  invertTree(root.left) ;
    if(root.right != null)  invertTree(root.right) ;

    let temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
};


// ---just to execute --
function TreeNode(val, left, right) {
     this.val = (val===undefined ? 0 : val)
     this.left = (left===undefined ? null : left)
     this.right = (right===undefined ? null : right)
}

let root = [4,2,7,1,3,6,9]
let tree = createTree(root)
console.log(printTree(tree, []));
let invertedTree = invertTree(tree);
console.log(printTree(invertedTree, []));



function createTree(array){
    let head = new TreeNode(array[0], null, null);
    array = array.slice(1, array.length)
    for(let num of array){
        insertIntoTree(head, num);
    }
    return head;
}

function insertIntoTree(tree, number){
    if(number < tree.val) {
        if(tree.left == null) {
            tree.left = new TreeNode(number, null, null);
            return;
        }    
        insertIntoTree(tree.left, number)
    }
    else if(number > tree.val){
        if(tree.right == null){
            tree.right = new TreeNode(number,null,null);
            return;
        }
        insertIntoTree(tree.right, number);
    }
}

function printTree(root, print){
    print.push(root.val)
    if(root.left != null){
        printTree(root.left, print)
    }
    if(root.right != null){
        printTree(root.right, print)
    }
    return print

}
