class Solution {
    private int ladderLength(String beginWord, String endWord, Set<String> wordSet){
        int distance = 1;
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        while(!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for(String word: reached){
                for(int i=0; i<word.length(); i++){
                    char[] wordArr = word.toCharArray();
                    for(char ch='a'; ch<='z' ; ch++){
                        wordArr[i] = ch;
                        String str = new String(wordArr);
                        if(wordSet.contains(str)){
                            toAdd.add(str);
                            wordSet.remove(str);
                        }
                    }
                }
            }
            if(toAdd.size()==0){
                return 0;
            }
            distance++;
            reached = toAdd;
        }
        return distance;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        return ladderLength(beginWord, endWord, set);
    }
}