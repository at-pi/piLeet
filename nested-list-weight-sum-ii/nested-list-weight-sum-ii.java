/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    
    int maxDepth = 0;
    int ans = 0;
    
    public void findDepth(List<NestedInteger> list, int currDepth){
        
        int len = list.size();
        maxDepth = Math.max(maxDepth, currDepth);
        
        for(int i=0; i<len; i++){
            
            NestedInteger curr = list.get(i);
            
            if(!curr.isInteger()){
                findDepth(curr.getList(), currDepth+1);
            }
            
        }
        
    }
    
    public void recursion(List<NestedInteger> list, int depth){
        
        int len = list.size();
        
        for(int i=0; i<len; i++){
            
            NestedInteger curr = list.get(i);
            
            if(curr.isInteger()){
                ans += curr.getInteger() * (maxDepth - depth +1);
            }
            else{
                recursion(curr.getList(), depth+1);
            }
            
        }
        
    }
    
    public int depthSumInverse(List<NestedInteger> list) {
        
        int len = list.size();
        maxDepth = 1;
        
        for(int i=0; i<len; i++){
            
            NestedInteger curr = list.get(i);
            
            if(!curr.isInteger()){
                findDepth(curr.getList(), 2);
            }
            
        }
        //System.out.println(maxDepth);
        
        for(int i=0; i<len; i++){
            
            NestedInteger curr = list.get(i);
            
            if(curr.isInteger()){
                ans += curr.getInteger() * (maxDepth - 1 + 1);
            }
            else{
                recursion(curr.getList(), 2);
            }
            
        }
        
        return ans;
        
    }
}