class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    private void util(List<List<Integer>> list,List<Integer> temp){
        int n = temp.size();
        if(temp.get(n-1)==list.size()-1){
            ret.add(new ArrayList<>(temp));
            return;
        }
        List<Integer> itr = list.get(temp.get(n-1));
        
        for(int i=0;i<itr.size();i++){
            temp.add(itr.get(i));
            util(list,temp);
            temp.remove(temp.size()-1);
        }
        
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                //System.out.print(graph[i][j]+" ");
                list.get(i).add(graph[i][j]);
            }
            //System.out.println();
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        util(list,temp);
        return ret;
    }
}