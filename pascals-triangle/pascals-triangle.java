class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> l = new ArrayList<>();
            //System.out.println("i-"+i);
            for(int j=0;j<i;j++){
                //System.out.println("j-"+j);
                if(j==0){
                    //System.out.println("adding 1 start");
                    l.add(1);
                    //System.out.println(l);
                }
                else if(j==i-1){
                    //System.out.println("adding 1 end");
                    l.add(1);
                    //System.out.println(l);
                }
                else if(j>0 && j<i-1){
                    //System.out.println("adding between");
                    l.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
                    //System.out.println(l);
                }
                
            }
            list.add(l);
        }
        return list;
    }
}