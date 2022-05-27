/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
//     private int find(int start, int end){
//         if(start>end)
//             return -1;
        
//         int mid = (start+end)/2;
//         //System.out.println("start - "+start+" end - "+end+" mid - "+mid);
//         boolean call = this.isBadVersion(mid);
        
//         if(call){
//             if(this.isBadVersion(mid-1) == true)
//                 return find(start, mid-1);
//             return mid;
//         }
//         return find(mid+1, end);
//     }
    
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int ans = -1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(isBadVersion(mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}