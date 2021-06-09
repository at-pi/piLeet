class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    private void util(int n, int k, String num){
        //System.out.println(num);
        if(num.length()==n)
            set.add(Integer.parseInt(num));
        if(num.length()>n)
            return;
        int temp = Integer.parseInt(String.valueOf(num.charAt(num.length()-1)));
        if(temp+k<10)
            util(n,k,num+String.valueOf(temp+k));
        if(temp-k>=0)
            util(n,k,num+String.valueOf(temp-k));
        //num += String.vaueOf(temp+k);
        //util(n,k,num+String.vaueOf(temp+k));
        //util(n,k,num+String.vaueOf(temp-k));
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1;i<=9;i++){
            util(n,k,String.valueOf(i));
        }
        int[] arr = new int[set.size()];
        //set.toArray(arr);
        //System.out.println(list);
        // for(int i=0;i<list.size();i++)
        //     arr[i]=list.get(i);
        Iterator<Integer> i = set.iterator();
        int p = 0;
        while(i.hasNext()){
            arr[p]=i.next();
            p++;
        }
        return arr;
    }
}