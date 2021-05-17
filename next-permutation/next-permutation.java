class Solution {
    private void reverse(int[] nums,int start,int end){
        if(start>end)
            return;
        for(int i=start;i<=(start+end)/2;i++){
            swap(nums,i,start+end-i);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2)
            return;
        int i = n-1;
        while(i>0){
            if(nums[i]>nums[i-1]){
                break;
            }
            i--;
        }
        if(i==0){
            reverse(nums,0,n-1);
            return;
        }
        else{
            int j = n-1;
            int val = nums[i-1];
            //int index = n-1;
            while(j>=i){
                if(nums[j]>val){
                    break;
                }
                j--;
            }
            swap(nums,i-1,j);
            reverse(nums,i,n-1);
            return;
        }
    }
}