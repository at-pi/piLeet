//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    private static void recursion(int[][] grid, int x, int y, int[][] vis, StringBuilder strb, List<String> list){
        int n = grid.length;
        
        if(x < 0 || x>=n || y<0 || y>=n || grid[x][y] == 0 || vis[x][y] == 1){
            return;
        }
        
        if(x == n-1 && y == n-1){
            list.add(String.valueOf(strb));
            return;
        }
        
        vis[x][y] = 1;
        
        strb.append('D');
        recursion(grid, x+1, y, vis, strb, list);
        strb.deleteCharAt(strb.length()-1);
        
        strb.append('U');
        recursion(grid, x-1, y, vis, strb, list);
        strb.deleteCharAt(strb.length()-1);
        
        strb.append('R');
        recursion(grid, x, y+1, vis, strb, list);
        strb.deleteCharAt(strb.length()-1);
        
        strb.append('L');
        recursion(grid, x, y-1, vis, strb, list);
        strb.deleteCharAt(strb.length()-1);
        
        
        vis[x][y] = 0;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        int[][] vis = new int[n][n];
        ArrayList<String> list = new ArrayList<>();
        recursion(m, 0, 0, vis, new StringBuilder(), list);
        
        return list;
    }
}