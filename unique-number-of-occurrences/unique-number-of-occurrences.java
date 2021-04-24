class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] fre = new int[2001];
        for(int i=0;i<arr.length;i++){
            fre[arr[i]+1000]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<fre.length;i++){
            if(fre[i]!=0)
                if(list.contains(fre[i]))
                    return false;
            else
                list.add(fre[i]);
        }
        return true;
    }
}