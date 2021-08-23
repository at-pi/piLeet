class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] maxEndHere = new int[n], maxStartsHere = new int[n];
        int max = arr[0];
        
        maxEndHere[0] = arr[0];
        for(int i=1;i<n;i++){
            maxEndHere[i] = Math.max(maxEndHere[i-1]+arr[i],arr[i]);
            max = Math.max(max, maxEndHere[i]);
        }
        
        maxStartsHere[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            maxStartsHere[i] = Math.max(arr[i]+maxStartsHere[i+1],arr[i]);
        }
        
        for(int i=1;i<n-1;i++){
            max = Math.max(max,maxStartsHere[i+1]+maxEndHere[i-1]);
        }
        
        return max;
    }
}