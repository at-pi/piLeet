//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[][] jobs = new int[arr.length][3];
        int i=0;
        int maxDead = -1;
        for(Job temp: arr){
            jobs[i] = new int[]{temp.id, temp.deadline, temp.profit};
            // System.out.println("temp - "+jobs[i][0] +" " + jobs[i][1] + " " + jobs[i][2]);
            maxDead = Math.max(temp.deadline, maxDead);
            i++;
        }
        Arrays.sort(jobs, (a,b) -> b[2] - a[2]);
        
        int profit = 0;
        int number = 0;
        
        int[] joe = new int[maxDead+1];
        Arrays.fill(joe,-1);
        
        for(int[] temp: jobs){
            // System.out.println("temp - "+temp[0] +" " + temp[1] + " " + temp[2]);
            for(int j=temp[1]; j>=1; j--){
                if(joe[j] == -1){
                    joe[j] = temp[0];
                    number++;
                    profit += temp[2];
                    break;
                }
            }
        }
        return new int[]{number, profit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/