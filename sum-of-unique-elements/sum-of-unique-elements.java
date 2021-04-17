class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int[] arr = map.get(nums[i]);
                arr[1]++;
                map.put(nums[i],arr);
            }
            else{
                int[] arr = new int[2];
                arr[0] = nums[i];
                arr[1] = 1;
                map.put(nums[i],arr);
            }
        }
        int sum=0;
        for(int[] arr : map.values()){
            if(arr[1]==1){
                sum+=arr[0];
            }
        }
        return sum;
    }
}