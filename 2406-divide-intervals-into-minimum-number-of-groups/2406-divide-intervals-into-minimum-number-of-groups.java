class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] x: intervals){
            //System.out.println(x[0]+" "+x[1]);
            if(!pq.isEmpty() && pq.peek()<x[0]){
                pq.remove();
            }
            pq.add(x[1]);
        }
        
        return pq.size();
    }
}