class Solution {
    
    private int findHeight(Map<Integer, List<Integer>> map, int root){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        int height = -1;
        Set<Integer> set = new HashSet<>();
        //set.add()
        
        
        while(!q.isEmpty()){
            
            int size = q.size();
            height++;
            
            for(int i=0; i<size; i++){
                
                int curr = q.remove();
                set.add(curr);
                
                List<Integer> list = map.get(curr);
                for(int j=0; j<list.size(); j++){
                    if(!set.contains(list.get(j))){
                        q.add(list.get(j));
                    }
                }
            }   
        }
        
        return height;
    }
    
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
//         Map<Integer, List<Integer>> map = new HashMap<>();
        
//         for(int i=0; i<n; i++){
//             map.put(i, new ArrayList<Integer>());
//         }
        
//         for(int[] temp: edges){
//             map.get(temp[0]).add(temp[1]);
//             map.get(temp[1]).add(temp[0]);
//         }
        
//         int maxHeight = Integer.MAX_VALUE;
//         List<Integer> maxNodes = new ArrayList<>();
        
//         for(int i=0; i<n; i++){
            
//             int height = findHeight(map, i);
//             //System.out.println(height);
            
//             if(height < maxHeight){
//                 maxHeight = height;
//                 maxNodes = new ArrayList<>();
//                 maxNodes.add(i);
//             }
//             else if(height == maxHeight){
//                 maxNodes.add(i);
//             }
            
//         }
        
//         return maxNodes;
//     }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; ++i){
            graph.add(new HashSet<>());
        }
        
        for(int[] temp: edges){
            graph.get(temp[0]).add(temp[1]);
            graph.get(temp[1]).add(temp[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
        while(n > 2){
            
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int i: leaves){
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if(graph.get(j).size() == 1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}