class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int integerBreak(int n) {
        if(n<=2)
            return 1;
        if(map.containsKey(n))
            return map.get(n);
        int max =0;
        for(int i=1;i<=n-1;i++){
            int temp = i*(Math.max(n-i,integerBreak(n-i)));
            if(temp>max)
                max=temp;
        }
        map.put(n,max);
        return max;
    }
}