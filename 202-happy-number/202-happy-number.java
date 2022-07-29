class Solution {
    
    private int sumOfSquare(int n){
        int x = 0;
        while(n>0){
            //System.out.println("n - "+n);
            int k = n%10;
            x += k*k;
            n = n/10;
        }
        return x;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n)){
            
            int square = sumOfSquare(n);
            //System.out.println(square);
            if(square == 1)
                return true;
            n = square;
            
        }
        return false;
    }
}