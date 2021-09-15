class Solution {
    
    class Node{

        char c;
        Node[] arr;
        boolean isWord;
        String currWord;
        
        public Node(char c){
            this.c = c;
            this.currWord = this.currWord+c;
            this.arr = new Node[26];
            this.isWord = false;
        }

    }
    
    private void build(String word, Node root, int index){
        
        if(index>=word.length())
            return;
        
        //print(root);
        
        if(root.arr[word.charAt(index)-'a']==null){
            
            Node temp = new Node(word.charAt(index));
            temp.currWord = root.currWord+temp.c;
            root.arr[word.charAt(index)-'a'] = temp;
            
            if(index+1==word.length()){
                temp.isWord = true;
                //print(temp);
                return;
            }
            
            build(word, temp, index+1);
            
        }
        else{
            
            if(index+1==word.length()){
                root.arr[word.charAt(index)-'a'].isWord=true;
                //print(root.arr[word.charAt(index)-'a']);
            }
            
            build(word, root.arr[word.charAt(index)-'a'], index+1);
            
        }
        
    }
    
    private void buildTrie(String[] words, Node root){
        
        for(int i=0;i<words.length;i++){
            build(words[i],root,0);
        }
        
    }
    
    private void print(Node root){
        System.out.print(root.c+" "+root.isWord);
        for(int i=0;i<26;i++){
            System.out.print(" "+root.arr[i]+" ");
        }
        System.out.println();
    }
    
    private void recursion(char[][] board, int i, int j, Node root, List<String> list){
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='*' || root.arr[board[i][j]-'a']==null){
            return;
        }
        
        char c = board[i][j];
        
        
        //System.out.println("letter - "+c+" root- "+root.c+ " found - "+root.arr[board[i][j]-'a'].c +" isWord? "+root.arr[board[i][j]-'a'].isWord +" currWord "+root.arr[board[i][j]-'a'].currWord);
        
        //print(root.arr[board[i][j]-'a']);
        
        if(root.arr[c-'a'].isWord){
            list.add(root.arr[c-'a'].currWord);
            root.arr[c-'a'].isWord = false;
        }
        
        board[i][j] = '*';
        
        recursion(board, i+1, j, root.arr[c-'a'], list);
        recursion(board, i, j+1, root.arr[c-'a'], list);
        recursion(board, i-1, j, root.arr[c-'a'], list);
        recursion(board, i, j-1, root.arr[c-'a'], list);
        
        board[i][j] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Node root = new Node('/');
        root.currWord = "";
        
        buildTrie(words,root);
        
        int m = board.length;
        int n = board[0].length;
        List<String> list = new ArrayList<String>();
        
        //recursion(board, 0, 0, root, list);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                recursion(board, i, j, root, list);
            }
        }
        
        return list;
        
    }
}

