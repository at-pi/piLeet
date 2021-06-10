class Solution {
    
    private void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int[] nums2 = new int[n];
        for(int i=0;i<n;i++){
            nums2[i]=nums[i];
        }
        int opsEven = 0;
        for(int i=0;i<n;i=i+2){
            if(i==0){
                if(nums[i]>=nums[i+1]){
                    opsEven+=(nums[i]-nums[i+1])+1;
                    nums[i] = nums[i+1]-1;
                }
            }
            else if(i==n-1){
                if(nums[i]>=nums[i-1]){
                    opsEven+=(nums[i]-nums[i-1])+1;
                    nums[i] = nums[i-1]-1;
                }
            }
            else{
                int small = Math.min(nums[i-1],nums[i+1]);
                if(nums[i]>=small){
                    opsEven+=(nums[i]-small)+1;
                    nums[i]=small-1;
                }
            }
        }
        //print(nums);
        
        int opsOdd = 0;
        for(int i=1;i<n;i=i+2){
            if(i==n-1){
                if(nums2[i]>=nums2[i-1]){
                    opsOdd+=(nums2[i]-nums2[i-1])+1;
                    nums2[i] = nums2[i-1]-1;
                }
            }
            else{
                int small = Math.min(nums2[i-1],nums2[i+1]);
                if(nums2[i]>=small){
                    opsOdd+=(nums2[i]-small)+1;
                    nums2[i]=small-1;
                }
            }
        }
        //print(nums2);
        //System.out.println(opsEven+ " " +opsOdd);
        return Math.min(opsEven,opsOdd);
    }
}