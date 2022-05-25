/**
 * @param {string[]} words
 * @return {string[]}
 */
var removeAnagrams = function(words) {
    
    let ret = [];
    let previous = '';
    
    for(let i=0; i<words.length; i++){ 
        
        let curr = words[i];  
        let currArr = curr.split(''); 
        currArr = currArr.sort();
        curr = currArr.join(''); 
        
        if(previous !== curr){
            ret.push(words[i]);
            previous = curr;
        }
        
    }
    
    return ret;
};