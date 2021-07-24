class Trie {
    
    Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('/');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertTrie(root, word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        return searchTrie(root,word,0);
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        return startsWithTrie(root,prefix,0);
    
    }
    
    private void insertTrie(Node root, String s, int curr){
        
        if(curr>=s.length())
            return;
        
        if(root.arr[s.charAt(curr)]!=null){
            
            //System.out.println("using - "+root.arr[s.charAt(curr)].c);
            
            insertTrie(root.arr[s.charAt(curr)], s, curr+1);
            
            if(curr==s.length()-1){
                root.arr[s.charAt(curr)].isWord = true;
            }
            
        }
        else{
            //System.out.println("creating - "+s.charAt(curr));
            Node temp = new Node(s.charAt(curr));
            root.arr[s.charAt(curr)] = temp;
            insertTrie(temp, s, curr+1);
            
            if(curr==s.length()-1){
                temp.isWord = true;
            }
            
        }
    }
    
    private boolean searchTrie(Node root, String s, int curr){
        
        if(curr>=s.length())
            return false;
        
        if(root.arr[s.charAt(curr)]!=null){
            //System.out.println("entering - "+root.arr[s.charAt(curr)].c);
            if(curr==s.length()-1){
                //System.out.println("final letter , isword? "+root.arr[s.charAt(curr)].isWord);
                return root.arr[s.charAt(curr)].isWord;
            }
            else{
                //System.out.println("searching further ");
                return searchTrie(root.arr[s.charAt(curr)], s, curr+1);
            }
        }
        return false;
    }
    
    private boolean startsWithTrie(Node root, String s, int curr){
        if(curr>=s.length())
            return false;
        else{
            if(root.arr[s.charAt(curr)]!=null){
                //System.out.println("entering - "+root.arr[s.charAt(curr)].c);
                if(curr==s.length()-1){
                    //System.out.println("final letter met true");
                    return true;
                }
                else{
                    //System.out.println("searching further in - "+root.arr[s.charAt(curr)].c);
                    return startsWithTrie(root.arr[s.charAt(curr)],s,curr+1);
                }
            }
        }
        return false;
    }
}

public class Node{
    
    char c;
    Node[] arr;
    boolean isWord;
    
    Node(char c){
        this.c = c;
        this.arr = new Node[256];
        this.isWord = false;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */