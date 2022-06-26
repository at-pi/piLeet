class Solution {
    
    private void print(int[][] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[0].length; j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    private int kadane(int[] nums1, int[] nums2){
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int i=0; i<nums1.length; i++){
            maxEndingHere += nums2[i] - nums1[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
    
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
     
        int total1 = Arrays.stream(nums1).sum();
        int total2 = Arrays.stream(nums2).sum();
        
        int max = Math.max(total1, total2);
        
        return Math.max(total1 + kadane(nums1, nums2), total2 + kadane(nums2, nums1));
        //print(dp1);
        //System.out.println("----------------------------");
        //print(dp2);
        
    }
}