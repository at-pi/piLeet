class Solution {
    
    boolean[] vis;
    
    private void print(boolean[] vis){
        for(int i=0;i<vis.length;i++){
            System.out.print(vis[i]+" ");
        }
        System.out.println();
    }
    
    private void recursion(List<Integer> list, List<List<Integer>> rooms){
        for(int i=0;i<list.size();i++){
            if(!vis[list.get(i)]){
                vis[list.get(i)]=true;
                //print(vis);
                recursion(rooms.get(list.get(i)),rooms);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        vis = new boolean[rooms.size()];
        //print(vis);
        vis[0] = true;
        //print(vis);
        
        recursion(rooms.get(0),rooms);
        
        //print(vis);
        
        for(int i=0;i<rooms.size();i++){
            if(!vis[i])
                return false;
        }
        
        return true;
    }
}