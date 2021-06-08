class Solution {
    
    private boolean util(int target,int curr, int currPow){
        if(curr+Math.pow(3,currPow)>target)
            return false;
        curr = curr+(int)Math.pow(3,currPow);
        if(curr==target)
            return true;
        curr = curr-(int)Math.pow(3,currPow);
        return util(target,curr+(int)Math.pow(3,currPow),currPow+1)||util(target,curr,currPow+1);
    }
    
    public boolean checkPowersOfThree(int n) {
        return util(n,0,0);
    }
}