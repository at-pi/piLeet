class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] a = new int[k];
        for(int i=0;i<k;i++){
            a[i]=nums[i+(n-k)];
        }
        int[] b = new int[n-k];
        for(int i=0;i<n-k;i++){
            b[i]=nums[i];
        }
        //int[] ret = new int[n];
        for(int i=0;i<n;i++){
            if(i<k){
                nums[i]=a[i];
            }
            else{
                nums[i]=b[i-k];
            }
        }
    }
}