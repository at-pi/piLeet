class Solution {
    
    private void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    public int numTeams(int[] arr) {
        int n = arr.length;
        int[] lessLeft = new int[n];
        int[] greaterLeft = new int[n];
        int[] lessRight = new int[n];
        int[] greaterRight = new int[n];
        
        for(int i=0;i<n;i++){
            int less = 0;
            int greater = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    less++;
                if(arr[j]>arr[i])
                    greater++;
            }
            lessLeft[i] = less;
            greaterLeft[i] = greater; 
        }
        
        for(int i=n-1;i>=0;i--){
            int less = 0;
            int greater = 0;
            for(int j=n-1;j>i;j--){
                if(arr[j]<arr[i])
                    less++;
                if(arr[j]>arr[i])
                    greater++;
            }
            lessRight[i] = less;
            greaterRight[i] = greater;
        }
        //print(lessLeft);
        //print(greaterLeft);
        //print(lessRight);
        //print(greaterRight);
        
        int total = 0;
        
        for(int i=0;i<n;i++){
            total+= (lessLeft[i]*greaterRight[i])+(greaterLeft[i]*lessRight[i]);
        }
        
        return total;
    }
}