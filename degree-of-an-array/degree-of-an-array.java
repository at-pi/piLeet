class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] arr = new int[50000];
        int max = 0;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
            if( arr[nums[i]]>max)
                max =  arr[nums[i]];
        }
        //System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        //System.out.println(max);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max)
                list.add(i);
        }
        //System.out.println(list);
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            int s =-1;
            int e =-1;
            int j=0;
            while(nums[j]!=list.get(i)){
                j++;
            }
            s=j;
            int k=nums.length-1;
            while(nums[k]!=list.get(i)){
                k--;
            }
            e=k;
            //System.out.println(list.get(i)+"s"+s+"e"+e);
            if(e-s<ret){
                ret = e-s+1;
            }
        }
        return ret;
    }
}