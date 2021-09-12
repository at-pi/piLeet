/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    Robot robot;
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    Set<Pair<Integer,Integer>> vis = new HashSet<>();
    
    public void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    public void backtrack(int row, int col, int d){
        vis.add(new Pair(row,col));
        robot.clean();
        
        for(int i=0;i<4;++i){
            int newD = (d+i)%4;
            int newRow = row + dir[newD][0];
            int newCol = col + dir[newD][1];
            
            if(!vis.contains(new Pair(newRow,newCol)) && robot.move()){
                backtrack(newRow, newCol, newD);
                goBack();
            }
            
            robot.turnRight();
        }
    }
    
    public void cleanRoom(Robot robot) {
        this.robot=robot;
        backtrack(0,0,0);
    }
}