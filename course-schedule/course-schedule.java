class Solution {
    private boolean util(List<List<Integer>> list, int[] vis, int v){
        if(vis[v]==2)
            return true;
        vis[v] = 2;
        for(int j=0;j<list.get(v).size();j++){
            if(vis[list.get(v).get(j)]!=1)
                if(util( list, vis,list.get(v).get(j) ))
                    return true;
        }
        vis[v]=1;
        return false;
    }
    private void print(List<List<Integer>> list){
        for(int i=0;i<list.size();i++){
            System.out.print(i+"-");
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            
            list.get(pre[i][0]).add(pre[i][1]);
        }
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0)
            if(util(list,vis,i))
                return false;
        }
        //print(list);
        return true;
    }
}