class Solution {
    public String reverseWords(String s) {
        
        String[] arr = s.split(" ");
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i].trim();
            if(arr[i].equals("")){
                
            }
            if(arr[i].equals(" ")){
                
            }
            else{
                list.add(arr[i]);
            }
        }
        System.out.println(list);
        String ret = "";
        for(int i=list.size()-1; i>=0; i--){
            if(!list.get(i).equals(""))
                ret+=list.get(i)+" ";
        }
        
        ret = ret.trim();
        return ret;
    }
}