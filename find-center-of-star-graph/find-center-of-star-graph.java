class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<edges.length+1;i++){
            map.put(i+1,0);
        }
        //System.out.println(map);
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length;j++){
                //System.out.print(edges[i][j]+" ");
                map.put(edges[i][j],map.get(edges[i][j])+1);
            }
            //System.out.println();
        }
        //System.out.println(map);
        int max = Integer.MIN_VALUE;
        int ret = -1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                ret = entry.getKey();
            }
        }
        
        return ret;
    }
}