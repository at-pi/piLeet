class Solution {
    public static String customSortString(String order, String str) {

        HashSet<Character>[] arr = new HashSet[256];

        for (int i = 0; i < arr.length; ++i)
            arr[i] = new HashSet<Character>();

        for(int i=0;i<order.length();i++){
            for(int j=i+1;j<order.length();j++){
                arr[order.charAt(i)].add(order.charAt(j));
            }
        }
        
        if(str.length()==0)
            return str;
        
        String ret = String.valueOf(str.charAt(0));

        for(int i=1;i<str.length();i++){
            char temp = str.charAt(i);
            int flag = 0;
            for(int j = 0 ;j<ret.length();j++){
                char curr = ret.charAt(j);
                if(arr[temp].contains(curr)){
                    String temp1 = ret.substring(0,j);
                    String temp2 = "";
                    if(j<ret.length())
                        temp2 = ret.substring(j,ret.length());
                    ret = temp1 + String.valueOf(temp) + temp2;
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                ret+= temp;
            }
        }
        return ret;
    }

}