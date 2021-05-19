class Solution {
    
    private boolean bs(int[] arr, int target, int left, int right){
        if(left>right){
            return false;
        }
        int mid = (left+right)/2;
        if(arr[mid]==target)
            return true;
        else if(target>arr[mid]){
            return bs(arr,target,mid+1,right);
        }
        else{
            return bs(arr,target,left,mid-1);
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(bs(matrix[i],target,0,n-1)){
                return true;
            }
        }
        return false;
    }
}