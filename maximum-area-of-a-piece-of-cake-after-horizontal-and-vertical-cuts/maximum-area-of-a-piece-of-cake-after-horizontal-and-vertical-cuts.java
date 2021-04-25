class Solution {
    public int maxArea(int h, int w, int[] ha, int[] va) {
        Arrays.sort(ha);
        Arrays.sort(va);
        long maxh = ha[0];
        //System.out.println(maxh);
        long maxv = va[0];
        // int diffh = 0;
        // int diffv = 0;
        
        for(int i=1;i<ha.length;i++){
            System.out.println(maxh);
            if(ha[i]-ha[i-1]>maxh){
                maxh=ha[i]-ha[i-1];
            }
        }
        if(h-ha[ha.length-1]>maxh)
            maxh=h-ha[ha.length-1];
        // System.out.println(maxh);
        for(int i=1;i<va.length;i++){
            if(va[i]-va[i-1]>maxv){
                maxv=va[i]-va[i-1];
            }
        }
        if(w-va[va.length-1]>maxv)
            maxv=w-va[va.length-1];
        //System.out.println(maxh+" "+maxv);
        long x = (maxh*maxv)%1000000007;
        return (int)x;
    }
}