class Solution {
        public class Pair{
        int x; 
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
    
    private int distance(Pair p){
        return ((p.x*p.x)+(p.y*p.y));
    }
    
    public int[][] kClosest(int[][] points, int k) {
        Map<Pair,Integer> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
            Pair p = new Pair(points[i][0],points[i][1]);
            int dist = distance(p);
            map.put(p,dist);
        }
        
        PriorityQueue<Map.Entry<Pair,Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        pq.addAll(map.entrySet());
        
        int ret[][] = new int[k][2];
        for(int i=0;i<k;i++){
            Map.Entry<Pair,Integer> e = pq.poll();
            ret[i][0] = e.getKey().getX();
            ret[i][1] = e.getKey().getY();
        }
        return ret;
    }
}