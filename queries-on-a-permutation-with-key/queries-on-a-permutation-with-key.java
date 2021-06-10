class Solution {
    
    private void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] ret = new int[n];
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i]=i+1;
        }
        for(int i=0;i<n;i++){
            int temp = queries[i];
            //print(arr);
            //System.out.println(temp);
            int flag = 0;
            if(arr[0]==temp){
                //System.out.println("found at 0");
                flag = 1;
                ret[i]=0;
            }
            if(flag ==0){
                int prev = arr[0];
                for(int j=1;j<m;j++){
                    if(arr[j]!=temp){
                        int t = arr[j];
                        arr[j]=prev;
                        prev = t;
                    }
                    else{
                        //System.out.println("found at - "+j);
                        arr[j]=prev;
                        ret[i]=j;
                        break;
                    }
                    
                }
                arr[0]=temp;
            }
            //print(arr);
        }
        
        return ret;
    }
}