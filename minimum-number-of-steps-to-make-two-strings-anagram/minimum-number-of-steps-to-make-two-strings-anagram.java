class Solution {
    public int minSteps(String s, String t) {
        int[] mapS = new int[26];
        int[] mapT = new int[26];
        for(int i=0;i<s.length();i++){
            mapS[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            mapT[t.charAt(i)-'a']++;
        }
        int sum = 0;
        for(int i=0;i<26;i++){
            sum+= (mapS[i]-mapT[i])>0?(mapS[i]-mapT[i]):0;
        }
        return sum;
    }
}