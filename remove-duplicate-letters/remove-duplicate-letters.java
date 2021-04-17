class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int[] frequency = new int[128];
        for(int i=0;i<arr.length;i++){
            frequency[arr[i]]++;
        }
        Deque<Character> d = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(d.isEmpty()){
                d.add(arr[i]);
                frequency[arr[i]]--;
                continue;
            }
            if(d.contains(arr[i])){
                frequency[arr[i]]--;
                continue;
            }
            while(!d.isEmpty() && d.getLast()>arr[i] && frequency[d.getLast()]>0){
                d.pollLast();
            }
            d.add(arr[i]);
            frequency[arr[i]]--;
        }
        StringBuilder strb = new StringBuilder();
        while(!d.isEmpty()){
            strb.append(d.pollFirst());
        }
        return strb.toString();
    }
}