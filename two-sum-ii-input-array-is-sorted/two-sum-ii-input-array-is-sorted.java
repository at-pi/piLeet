class Solution {
    public int[] twoSum(int[] arr, int target) {
        
        int[] ans = new int[2];
        int n = arr.length;
        int left = 0;
        int right = n-1;
        
        while(left<right){
            //System.out.println(left+" "+right);
            if(arr[left]+arr[right] == target){
                //System.out.println("inside "+left+" "+right);
                ans[0]=left+1;
                ans[1]=right+1;
                break;
            }
            else if(arr[left]+arr[right] < target){
                left++;
            }
            else{
                right--;
            }
            //System.out.println("hi");
        }
        return ans;
    }
}