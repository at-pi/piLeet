class Solution {
    public int minPartitions(String n) {
        int a = 0;
        for(int i=0;i<n.length();i++){
            //System.out.println(n.charAt(i)-'0');
            if((int)(n.charAt(i)-'0')>a)
                a=(int)(n.charAt(i)-'0');                
        }
        return a;
    }
}