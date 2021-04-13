class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] nums = new int[arr.length*2];
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i%arr.length];
        }
        //System.out.println(nums[0]+" "+nums[3]+" "+nums[4]+" "+nums[5]);
        Stack<List<Integer>> s = new Stack<>();
        int ret[] = new int[arr.length];
        Arrays.fill(ret,-1);
        for(int i=0;i<nums.length;i++){
            if(s.isEmpty() && i<arr.length){
                List<Integer> list = new ArrayList<>(); 
                list.add(nums[i]);
                list.add(i);
                System.out.println("push-"+list.get(0)+" "+list.get(1));
                s.push(list);
            }
            else{
                while(!s.isEmpty() && s.peek().get(0)<nums[i]){
                    List<Integer> l1 = s.pop();
                    System.out.println("pop-"+l1.get(0)+" "+l1.get(1));
                    ret[l1.get(1)] = nums[i];
                }
                if((i<arr.length)){
                    List<Integer> list = new ArrayList<>(); 
                    list.add(nums[i]);
                    list.add(i);
                    System.out.println("push-"+list.get(0)+" "+list.get(1));
                    s.push(list);
                }
            }
        }
        return ret;
    }
}