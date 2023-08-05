//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> ans = new ArrayList<>();
    private void subSum(ArrayList<Integer> arr, int N, int i, int currSum){
        if(i>N){
            return;
        }
        
        if(i == N){
            ans.add(currSum);
            return;
        }
        
        subSum(arr, N, i+1, currSum);
        if(i+1 == N){
            return;
        }
        subSum(arr, N, i+1, currSum+arr.get(i+1));
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        int i = -1;
        int currSum = 0;
        
        subSum(arr, N, i, 0);
        
        return ans;
    }
}