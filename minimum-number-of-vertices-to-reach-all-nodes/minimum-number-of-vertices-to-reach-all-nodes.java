class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] arr = new int[n];
        for(List<Integer> list : edges){
            arr[list.get(1)]=1;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                ret.add(i);
            }
        }
        return ret;
    }
}