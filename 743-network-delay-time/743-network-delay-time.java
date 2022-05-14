class Solution {
    
    int[] processed;
    int[] value;
    int[] parent;
    
    private int selectMinVertex(int[] value, int[] processed){
        int min = Integer.MAX_VALUE;
        int U = -1;
        for(int i=0; i<value.length ; i++){
            if(processed[i]==-1 && value[i]<=min){
                min = value[i];
                U = i;
            }
        }
        return U;
    }
    
    private void djikstra(int[][] graph, int n, int k){
        
        value = new int[n];
        Arrays.fill(value, Integer.MAX_VALUE);
        
        processed = new int[n];
        Arrays.fill(processed, -1);
        
        parent = new int[n];
        
        value[k] = 0;
        parent[k] = -1;
        //print1D(processed);
        for(int i=0; i<n ; i++){
            // System.out.print(i+" - ");
            // print1D(value);
            // System.out.print("- hry - ");
            // print1D(processed);
            int U = selectMinVertex(value, processed);
            processed[U] = 1;
            
            for(int j=0; j<n ; j++){
                if(graph[U][j]!=0 && processed[j]==-1 && value[U]!=Integer.MAX_VALUE && (value[U]+graph[U][j]<value[j])){
                    parent[j] = U;
                    value[j] = value[U]+graph[U][j];
                }
            }
            
        }
    }
    
    private void print1D(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    private void print2D(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+"-");
            }
            System.out.println();
        }
    }
    
    private int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length ; i++){
            if(arr[i] == Integer.MAX_VALUE)
                return -1;
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        pq.add(new int[]{0, K});
        
        boolean[] visited = new boolean[N+1];
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
            
    
    }
}