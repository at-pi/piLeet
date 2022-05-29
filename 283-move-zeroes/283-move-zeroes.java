class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        int zero = 0;
        int nonZero = 0;
        while(zero<n && nums[zero] != 0){
            zero++;
        }
        nonZero = zero;
        while(zero<n && nonZero<n){
            while(zero<n && nums[zero] != 0){
                zero++;
                // if(zero>=n)
                //     break;
            }
            while(nonZero<n && nums[nonZero] == 0){
                nonZero++;
                // if(nonZero>=n)
                //     break;
            }
            //System.out.println("zero - "+zero+" nonZero - "+nonZero);
            if(zero>=n || nonZero>=n){
                //System.out.println("breaking");
                break;
            }
            int temp = nums[zero];
            nums[zero] = nums[nonZero];
            nums[nonZero] = temp;
        }
    }
}