class Solution {
    
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (a.length() != b.length() ? b.length()-a.length() : b.compareTo(a)));
        
        for(int i=0 ; i<nums.length ; i++){
            pq.add(nums[i]);
        }
        
        String ans = "";
        while(k>0){
            ans = pq.remove();
            k--;
        }
        
        return ans;
    }
}