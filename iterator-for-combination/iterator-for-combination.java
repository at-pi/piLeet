class CombinationIterator {
    List<String> list = new ArrayList<>();
    int index = 0;
    private String swap(String s,int l, int r){
        char[] arr = s.toCharArray();
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return String.valueOf(arr);
    }
    private void util(String s, int count, String curr,int i){
        //System.out.println(curr);
        if(curr.length()==count){
            list.add(curr);
            return;
        }
        if(i>=s.length()-1)
            return;

        if(curr.length()==count){
            System.out.println(curr);
            list.add(curr);
        }
        util(s,count,curr+s.charAt(i+1),i+1);
        util(s,count,curr,i+1);
    }
    
    public CombinationIterator(String s, int count) {
        for(int i=0;i<s.length();i++){
            //s = swap(s,0,i);
            util(s,count,String.valueOf(s.charAt(i)),i);
            //s = swap(s,0,i);
        }
        //System.out.println(list);
    }
    
    public String next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        if(index+1>list.size())
            return false;
        else
            return true;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */