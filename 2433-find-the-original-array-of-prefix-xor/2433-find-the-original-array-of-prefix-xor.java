class Solution {
    public int[] findArray(int[] perf) {
        int n = perf.length;
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            if(i == 0){
                arr[i] = perf[i];
                continue;
            }
            arr[i] = perf[i] ^ perf[i-1];
        }
        return arr;
    }
}