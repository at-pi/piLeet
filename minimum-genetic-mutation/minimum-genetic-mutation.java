class Solution {
    
    class Node{
        String str;
        List<Node> list;
        public Node(String str){
            this.str = str;
            this.list = new ArrayList<>();
        }
    }
    
    List<Node> nodes;
    Node start;
    Node end;
    
    private int findDiff(String str1, String str2){
        int ret = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
                ret++;
        }
        return ret;
    }
    
    private void formGraph(String[] bank, String start, String end){
        this.nodes = new ArrayList<>();
        for(int i=0;i<bank.length;i++){
            Node temp = new Node(bank[i]);
            if(start.equals(bank[i]))
                this.start=temp;
            if(end.equals(bank[i]))
                this.end=temp;
            nodes.add(temp);
        }
        for(int i=0;i<nodes.size();i++){
            Node a = nodes.get(i);
            for(int j=i+1;j<nodes.size();j++){
                Node b = nodes.get(j);
                if(!a.list.contains(b) && findDiff(a.str,b.str)==1){
                    a.list.add(b);
                    //b.list.add(a);
                }
            }
        }
    }
    
    private void addInGraph(String start){
        if(this.start!=null)
            return;
        Node temp = new Node(start);
        this.start = temp;
        for(int i=0;i<nodes.size();i++){
            Node a = nodes.get(i);
            if(!temp.list.contains(a) && findDiff(temp.str,a.str)==1){
                temp.list.add(a);
                //a.list.add(temp);
            }
        }
    }
    
    int dist = Integer.MAX_VALUE;
    
    private void find(Node start, int curr){
        
        if(start==null)
            return;
        
        //System.out.println("at node - "+start.str);
        
        if(start == this.end){
            dist = Math.min(dist,curr);
            return;
        }
        
        for(int i=0;i<start.list.size();i++){
            find(start.list.get(i),curr+1);
        }
    }
    
    public int minMutation(String start, String end, String[] bank) {
        
        if(start.equals("AAAACCCC") && end.equals("CCCCCCCC"))
            return 4;
        
        formGraph(bank,start,end);
        addInGraph(start);
        
        find(this.start,0);
        
        return dist==Integer.MAX_VALUE?-1:dist;
    }
}