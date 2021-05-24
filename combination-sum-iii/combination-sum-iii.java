class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    private void util(int n,int k,int curr,int i, List<Integer> temp){
        if(i>9)
            return;
        if(k<0)
            return;
        if(curr==n && k==0){
            ret.add(new ArrayList<>(temp));
            return;
        }
        
        else{
            util(n,k,curr,i+1,temp);
            temp.add(i+1);
            util(n,k-1,curr+i+1,i+1,temp);
            temp.remove(temp.size()-1);
        }
        
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        util(n,k,0,0,temp);
        return ret;
    }
}