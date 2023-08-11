//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        if(n > m){
            return kthElement(arr2, arr1, m, n, k);
        }
        
        int low = 0;
        int high = (n+m+1)/2;
        
        while(low <= high){
            // System.out.println("low high - "+ low+" "+high);
            int mid = (low + high) / 2;
            // System.out.println("mid - "+mid);
            
            if(mid > k){
                high = mid-1;
                continue;
            }
            
            int cut1 = mid;
            if(cut1 > n){
                high = mid-1;
                continue;
            }
            int cut2 = k - mid;
            if(cut2 > m){
                low = mid+1;
                continue;
            }
            // System.out.println("cut1 - "+cut1+ " cut2 - "+cut2);
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];
            
            // System.out.println("l1 l2 r1 r2 - "+l1+" "+l2+" "+r1+" "+r2);
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }
            
            if(l1 > r2){
                // System.out.println("moving left ");
                high = mid-1;
            } else {
                low = mid+1;
                // System.out.println("moving right ");
            }
        }
        
        return 0;
    }
}