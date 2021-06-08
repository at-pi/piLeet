class Solution {
    //List<Integer> list = new ArrayList<>();
    public boolean canReach(int[] arr, int start) {
        
        //System.out.println(list);
        
        if(start<0 || start>=arr.length || arr[start]<0)
            return false;
        
        //if(arr[start]==0)
            //return true;
        
        arr[start] = -arr[start]; 
        //list.add(start);
        //boolean bool1 = canReach(arr,start+arr[start]);
        //boolean bool2 = canReach(arr,start-arr[start]);
        //list.remove(list.size()-1);
        
        return arr[start]==0 || canReach(arr,start+arr[start]) || canReach(arr,start-arr[start]);
    }
}