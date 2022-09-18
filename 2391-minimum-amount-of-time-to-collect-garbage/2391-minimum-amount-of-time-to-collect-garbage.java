class Solution {
    
    private int findO(String str, String temp){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(String.valueOf(str.charAt(i)).equals(temp)){
                count++;
            }
        }
        return count;
    }
    
    private int util(String[] garbage, int[] travel, String temp){
        int count = findO(garbage[0], temp);
        int distC = 0;
        
        for(int i=1; i<garbage.length; i++){
            distC += travel[i-1];
            if(garbage[i].contains(temp)){
                count += findO(garbage[i], temp);
                count += distC;
                distC = 0;
            }
        }
        
        return count;
    }
    
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int ans = 0;
        
        ans += util(garbage, travel, "G");
        //System.out.println(util(garbage, travel, "G"));
        ans += util(garbage, travel, "P");
        //System.out.println(util(garbage, travel, "P"));
        ans += util(garbage, travel, "M");
        //System.out.println(util(garbage, travel, "M"));
        
        return ans;
    }
}