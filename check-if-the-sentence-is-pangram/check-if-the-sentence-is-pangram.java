class Solution {
    public boolean checkIfPangram(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            System.out.print(arr[i]);
            if(arr[i]==0)
                return false;
        }
        return true;
    }
}