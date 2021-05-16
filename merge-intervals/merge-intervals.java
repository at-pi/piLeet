class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> list = new ArrayList<>();
        int[] newI = arr[0];
        list.add(newI);
        for(int[] I:arr){
            if(I[0]<=newI[1]){
                newI[1] = Math.max(I[1],newI[1]);
            }
            else{
                newI=I;
                list.add(newI);
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}