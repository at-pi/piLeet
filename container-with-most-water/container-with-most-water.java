class Solution {
    public int maxArea(int[] arr) {
        
        int i = 0;
        int j = arr.length-1;
        int max = Integer.MIN_VALUE;
        
        while(i<j){
            
            int area = Math.min(arr[i],arr[j]) * (j-i);
            max = Math.max(max,area);
            
            if(arr[i]<arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        
        return max;
    }
}