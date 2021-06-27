class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        TreeMap<Integer,Integer> dp = new TreeMap<>();
        dp.put(0,0);
        Map.Entry<Integer,Integer> temp = null;
        for(int[] arrt:arr){
            int cur = dp.floorEntry(arrt[0]).getValue() + arrt[2];
            if(cur>dp.lastEntry().getValue())
                dp.put(arrt[1],cur);
        }
        return dp.lastEntry().getValue();
    }
}