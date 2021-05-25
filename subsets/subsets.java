class Solution {
    
    private void util(List<List<Integer>> list, List<Integer> temp,int i,int[] nums){
        if(i>nums.length-1)
            return;
        util(list,new ArrayList<Integer>(temp),i+1,nums);
        temp.add(nums[i]);
        util(list,new ArrayList<Integer>(temp),i+1,nums);
        list.add(temp);
        //temp.remove(temp.size()-1);
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        util(list,new ArrayList<Integer>(),0,nums);
        return list;
    }
}