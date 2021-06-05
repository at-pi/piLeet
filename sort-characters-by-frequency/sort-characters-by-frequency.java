class Solution {
    public String frequencySort(String s) {
        int[][] arr = new int[126][2];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)][0]=s.charAt(i);
            arr[s.charAt(i)][1]++;
        }
        Arrays.sort(arr,(i1,i2)->Integer.compare(i2[1],i1[1]));
        String ret = "";
        for(int i=0;i<126;i++){
            //System.out.println(arr[i][0]+" "+arr[i][1]);
            if(arr[i][1]==0)
                break;
            else{
                for(int j=0;j<arr[i][1];j++){
                        ret+=(char)(arr[i][0]);
                }
            }
        }
        return ret;
    }
}