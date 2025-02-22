var isValid = function(s) {
    paranthesisMap = {')':'(','}': '{',']': '['};
    stack = [];
    for(let char of s){
        if(! (char in paranthesisMap)){
            stack.push(char);
            continue;
        }
        if(stack.pop() != paranthesisMap[char]){
             return false;
        }
        
    }
    if(stack.length == 0){
        return true;
    } 
    return false;  
};

console.log(isValid('()'));