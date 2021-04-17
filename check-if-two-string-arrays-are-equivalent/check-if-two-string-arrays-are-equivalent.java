class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder strb1 = new StringBuilder();
        for(int i=0;i<word1.length;i++){
            strb1.append(word1[i]);
        }
        StringBuilder strb2 = new StringBuilder();
        for(int i=0;i<word2.length;i++){
            strb2.append(word2[i]);
        }
        return String.valueOf(strb1).equals(String.valueOf(strb2))?true:false;
    }
}