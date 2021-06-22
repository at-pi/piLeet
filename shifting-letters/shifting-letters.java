class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int arr[] = new int[n];
        arr[n-1] = shifts[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i] = shifts[i]+arr[i+1];
            
            arr[i] = arr[i]%26;
            //System.out.print(arr[i]+" ");
        }
        arr[n-1] = arr[n-1]%26;
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
        String str = "";
        for(int i=0;i<n;i++){
            int temp = s.charAt(i)+arr[i];
            //System.out.println(temp);
            if(temp>122)
                temp-=26;
            //System.out.println(temp+" "+(char)(temp));
            str+=(char)(temp);
        }
        return str;
    }
}