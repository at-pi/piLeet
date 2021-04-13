class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<Integer>();
        int[] store = new int[10001];
        for(int i=0;i<nums2.length;i++){
            if(s.isEmpty())
                s.push(nums2[i]);
            else{
                if(nums2[i]<=s.peek())
                    s.push(nums2[i]);
                else{
                    while(!s.isEmpty() && s.peek()<nums2[i]){
                        store[s.pop()]=nums2[i];
                    }
                    s.push(nums2[i]);
                }
            }
        }
        while(!s.isEmpty()){
            store[s.pop()]=-1;
        }
        // for(int i=0;i<5;i++)
        //     System.out.println(i+"-"+store[i]);
        int[] ret = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ret[i]=store[nums1[i]];
        }
        return ret;
    }
}