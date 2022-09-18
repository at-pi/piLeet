class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] t1, int[] t2){
                return Integer.compare(t1[0],t2[0]);
            }
        });
        
        int ans = 0;
        
        for(int i=1; i<points.length; i++){
            if((points[i][0] - points[i-1][0]) > ans){
                ans = points[i][0] - points[i-1][0];
            }
        }
        
        return ans;
    }
}