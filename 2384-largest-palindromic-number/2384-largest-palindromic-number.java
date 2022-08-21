class Solution {
    public String largestPalindromic(String s) {
        int[] v=new int[10];
        for(int i=0;i<s.length();i++){
            v[(int)s.charAt(i)-48]++;
        }
        StringBuffer ans = new StringBuffer();
        int single = -1;
        for(int i=9;i>=0;i--){
            if(ans.length()==0 && i==0)continue;
            while(v[i]>1){
                ans.append((char)(i+48));
                v[i]-=2;
            }
            if(v[i]==1 && single == -1)single = i;
        }
        if(ans.length()==0 && single==-1)return "0";
        int i = ans.length()-1;
        if(single!=-1)ans.append((char)(single+48));
        for(;i>=0;i--){
            ans.append(ans.charAt(i));
        }
        return ans.toString();
    }
}