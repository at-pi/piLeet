class WordDictionary {
    
    class Node{
        char letter;
        Map<Character, Node> map;
        boolean isWord;
        
        public Node(char letter){
            this.letter = letter;
            map = new HashMap<>();
            this.isWord = false;
        }
    }
    
    Node root;
    
    private void add(Node root, String word, int i){
        if(i >= word.length())
            return;
        
        if(root.map.containsKey(word.charAt(i))){
            if(i == word.length()-1){
                root.map.get(word.charAt(i)).isWord = true;
            }
            add(root.map.get(word.charAt(i)), word, i+1);
        }
        else{
            root.map.put(word.charAt(i), new Node(word.charAt(i)));
            if(i == word.length()-1){
                root.map.get(word.charAt(i)).isWord = true;
            }
            add(root.map.get(word.charAt(i)), word, i+1);
        }
    }
    
    private boolean find(Node root, String word, int i){
        if(i >= word.length()){
            //System.out.println("returning true");
            return false;
        }
        //System.out.println(root.map);
        //System.out.println("node letter - "+root.letter+" index letter - "+word.charAt(i)+" i - "+i);
        
        if(word.charAt(i) == '.'){
            if(i == word.length()-1){
                boolean x = false;
                for(Map.Entry<Character, Node> entry : root.map.entrySet()){
                    x = x || entry.getValue().isWord;
                }
                return x;
            }
                
            boolean ret = false;
            for(Map.Entry<Character, Node> entry : root.map.entrySet()){
                ret = ret || find(entry.getValue(), word, i+1);
            }
            return ret;
        }
        else{
            if(root.map.containsKey(word.charAt(i))){
                if(i == word.length()-1){
                    return root.map.get(word.charAt(i)).isWord;
                }
                return find(root.map.get(word.charAt(i)), word, i+1);
            }
            return false;
        }
    }
    
    public WordDictionary() {
        this.root = new Node('.');
    }
    
    public void addWord(String word) {
        add(this.root, word, 0);
    }
    
    public boolean search(String word) {
        //System.out.println("word - "+word);
        return find(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */