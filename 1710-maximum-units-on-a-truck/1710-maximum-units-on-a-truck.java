class Solution {
    public int maximumUnits(int[][] arr, int truckSize) {
        Arrays.sort(arr, (a,b) -> b[1] - a[1]);
        
        int count = 0;
        int sum = 0;
        for(int i=0; count <= truckSize && i<arr.length ; i++){
            //System.out.println(arr[i][0]+" "+arr[i][1]);
            if(count + arr[i][0] > truckSize){
                //System.out.println("if");
                sum += (arr[i][1] * (truckSize - count));
                break;
            }
            else{
                //System.out.println("else");
                sum += arr[i][0] * arr[i][1];
                count += arr[i][0];
            }
        }
        
        return sum;
    }
}