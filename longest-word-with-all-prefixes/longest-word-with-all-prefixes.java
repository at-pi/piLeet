class Solution {
    
    class Node{
        
        char c;
        Node[] arr;
        boolean isWord;
        
        Node(char c){
            this.c = c;
            this.arr = new Node[26];
            this.isWord = false;
        }
        
        Node(char c, boolean isWord){
            this.c = c;
            this.arr = new Node[26];
            this.isWord = isWord;
        }
        
    }
    
    Node root;
    String word;
    
    private void makeTreeImpl(String str, int index, Node root){
        
        if(root == null || index>=str.length())
            return;
        
        if(root.arr[str.charAt(index)-'a']!=null){
            if(index == str.length()-1){
                root.arr[str.charAt(index)-'a'].isWord = true;
            }
            makeTreeImpl(str, index+1, root.arr[str.charAt(index)-'a']);
        }
        else{
            Node node = new Node(str.charAt(index));
            root.arr[str.charAt(index)-'a']=node;
            if(index == str.length()-1){
                node.isWord = true;
                return;
            }
            makeTreeImpl(str, index+1, node);
        }
    }
    
    private void makeTree(String[] words){
        for(int i=0; i<words.length; i++){
            makeTreeImpl(words[i], 0, root);
        }
    }
    
    private void findWord( Node root, String curr){
        if(root == null)
            return;
        
        curr += root.c;
        
        if(root.isWord==false)
            return;
        
        if(curr.length()>this.word.length()){
            this.word = curr;
        }
        
        for(int i=0;i<26;i++){
            if(root.arr[i]!=null){
                findWord(root.arr[i], curr);
            }
        }
    }
    
    public String longestWord(String[] words) {
        
        this.root = new Node('/',true);
        this.word = "";
        
        makeTree(words);
        findWord(root,"");
        
        if(word.length()>=1)
            return word.substring(1,word.length());
        else
            return "";
    }
}