var isAnagram = function(s, t) {
    
    let wordCount = {};

    for(let letter of s){
        wordCount[letter] = (wordCount[letter] || 0) + 1;
    }

    for(let letter of t){
        if(!wordCount[letter] || wordCount[letter]<0){
            return false;
        } else{
            wordCount[letter] = --wordCount[letter];
        }    
    }

    return Array.from(Object.values(wordCount)).every(count => count === 0);

};

console.log(isAnagram('ab', 'a'));