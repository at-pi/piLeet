class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        
        int count = 0;
        int rowSec1 = 0;
        for(int i = 0; i < m ; i++){
            //System.out.println("i - "+i);
            int rowSec2 = 0;
            for(int j=0 ; j<n ; j++){
                 if(bank[i].charAt(j) == '1'){
                     rowSec2++;
                 }
            }
            //System.out.println("rowSec2 =");
            if(rowSec2 == 0)
                continue;
            count += rowSec1*rowSec2;
            rowSec1 = rowSec2;
            rowSec2 =0;
        }
        return count;
    }
}