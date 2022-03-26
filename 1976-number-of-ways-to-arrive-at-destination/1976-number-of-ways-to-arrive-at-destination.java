class Solution {
    
    long[] dp;
    int[] dist;
    
    private void find(Map<Integer, List<int[]>> graph){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        
        pq.add(new int[]{0, 0});
        
        dp[0] = 1;
        dist[0] = 0;
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int U = temp[0];
            int d = temp[1];
            
            if(dist[U] < d)
                continue;
            
            for(int[] v: graph.get(U)){
                if(dist[v[0]] > d + v[1]){
                    dp[v[0]] = dp[U];
                    dist[v[0]] = d + v[1];
                    pq.offer(new int[]{v[0], dist[v[0]]});
                }
                else if(dist[v[0]] == d + v[1]){
                    dp[v[0]]+= dp[U];
                    dp[v[0]]%= 1_000_000_007;
                }
            }
        }
        
        
    }
    
    public int countPaths(int n, int[][] roads) {
        
        dp = new long[n];
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=0 ;i <n ; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] road: roads){
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        find(graph);
        
        return (int)dp[n-1]%1_000_000_007;
    }
    
    private void print(int[] arr){
        for(int i=0;i< arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    private void print(int[][] arr){
        for(int i=0; i< arr.length ; i++){
            for(int j=0; j<arr[0].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}