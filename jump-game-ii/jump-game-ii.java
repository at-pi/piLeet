class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] util = new int[n];
        for(int i=0;i<n;i++){
            util[i] = nums[i]+i;
            //System.out.print(util[i]+" ");
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=util[i];j>i;j--){
                map.put(j,i);
            }
        }
        int index = n-1;
        int count = 0;
        while(index!=0){
            index = map.get(index);
            count++;
        }
        //System.out.println(map);
        return count;
    }
}