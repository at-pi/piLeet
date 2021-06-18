class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<Integer> list = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int length = target.length;
        int itrList = 0;
        int itrTarget = 0;
        Stack<Integer> stack = new Stack<>();
        while(itrTarget<length){
            //System.out.println(itrList+" "+itrTarget);
            if(list.get(itrList)==target[itrTarget]){
                stack.push(list.get(itrList));
                ret.add("Push");
                itrList++;
                itrTarget++;
                //System.out.println(itrList+" "+itrTarget);
            }
            else{
                //System.out.println(itrList+" "+itrTarget);
                while(list.get(itrList)!=target[itrTarget]){
                    stack.push(list.get(itrList));
                    stack.pop();
                    ret.add("Push");
                    ret.add("Pop");
                    itrList++;
                    //System.out.println(itrList+" "+itrTarget);
                    
                }
            }
        }
        return ret;
    }
}