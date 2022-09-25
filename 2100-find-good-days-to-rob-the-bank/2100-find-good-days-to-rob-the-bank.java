class Solution {
    
    private void print(int[] arr){
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }    
    
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        
        for(int i=1; i<n-time; i++){
            if(security[i] <= security[i-1]){
                left[i] = left[i-1] + 1;
            }
            else{
                left[i] = 0;
            }
        }
        //print(left);
        
        int[] right = new int[n];
        
        for(int i = n-2; i>=0; i--){
            if(security[i] <= security[i+1]){
                right[i] = right[i+1] + 1;
            }
            else{
                right[i] = 0;
            }
        }
        //print(right);
        
        List<Integer> list = new ArrayList<>();
        for(int i=time; i<n-time; i++){
            if(left[i] >=time && right[i] >=time){
                list.add(i);
            }
        }
        
        return list;
    }
}