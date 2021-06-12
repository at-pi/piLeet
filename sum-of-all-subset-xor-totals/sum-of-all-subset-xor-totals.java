class Solution {
    int global = 0;
    
    private void XOR(List<Integer> list){
        int res = 0;
        for(int i=0;i<list.size();i++){
            res^=list.get(i);
        }
        //System.out.println(list+"-"+res);
        global+=res;
    }
    
    private void util(int[] nums, int curr, List<Integer> list){
        //System.out.println(curr+" String - "+str);
        if(curr==nums.length){
            XOR(list);
            return;
        }
        list.add(nums[curr]);
        util(nums,curr+1,list);//
        list.remove(list.size()-1);
        util(nums,curr+1,list);//util(arr,2,{1})
    }
    
    public int subsetXORSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        util(nums,0,list);
        return global;
    }
}