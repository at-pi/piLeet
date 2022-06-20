class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            
            boolean flag = false;
            //System.out.println("i - "+i);
            for(int j=0;j<list.size();j++){
                String g = list.get(j);
                //System.out.println("g - "+g);
                String check;
                String small;
                if(g.length() == words[i].length()){
                    check = g;
                    small = words[i];
                }
                else if(g.length() > words[i].length()){
                    check = g;
                    small = words[i];
                }
                else{
                    check = words[i];
                    small = g;
                }
                //System.out.println("check - "+check+" small - "+small);
                if(check.endsWith(small)){
                    //System.out.println("inside check small");
                    flag = true;
                    list.remove(j);
                    list.add(check);
                    break;
                }
            }
            if(flag == false){
                //System.out.println("adding - "+words[i]);
                list.add(words[i]);
            }
            //System.out.println(list);
        }
        //System.out.println(list);
        int ret = 0;
        for(int i=0;i<list.size();i++){
            ret+=list.get(i).length() + 1;
        }
        return ret;
    }
}