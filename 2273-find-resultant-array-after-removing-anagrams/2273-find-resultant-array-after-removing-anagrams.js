/**
 * @param {string[]} words
 * @return {string[]}
 */
var removeAnagrams = function(words) {
    
    let ret = [];
    let previous = '';
    for(let i=0; i<words.length; i++){ // i = 1; // i =2 // i=3 // i=4
        let curr = words[i];  //words[0] = "abba", curr = "abba" // curr = "baba" // curr = "bbaa" // curr = "cd" // curr = "cd"
        let currArr = curr.split(''); // ['a','b','b','a'] // 
        currArr = currArr.sort();//['a','a','b','b']
        curr = currArr.join(''); // curr = "aabb" // curr =  "aabb" // curr = "aabb" // curr = "cd" // curr = "cd"
        if(previous !== curr){ // prev = "", curr="aabb" // prev="aabb" curr="aabb" // prev = "aabb" curr = "aabb" // prev = "aabb" curr = "cd" // prev = "cd" curr = "cd"
            ret.push(words[i]);// ["abba", "cd" ]
            previous = curr; //prev = "aabb" // prev = "cd"
        }
    }
    
    return ret;
};