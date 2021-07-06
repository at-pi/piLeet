class Solution {
    
    private boolean check(String strBig, String strSmol){
        //System.out.println("comparing - "+strSmol+" "+strBig);
        String strSmolArr[] = strSmol.split("/");
        String strBigArr[] = strBig.split("/");
        
        boolean flag = true;
        
        for(int i=0;i<strSmolArr.length;i++){
            //System.out.println("loop comparing - "+strSmolArr[i]+" "+strBigArr[i]);
            if(!strSmolArr[i].equals(strBigArr[i]))
                return false;
        }
        
        return true;
    }
    
    public List<String> removeSubfolders(String[] folder) {
        
        int n = folder.length;
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<n;){
            String key = folder[i];
            list.add(key);
            //System.out.println("added "+key);
            i++;
            while(i<n && check(folder[i],key)){
                //System.out.println("skipping "+folder[i]);
                i++;
            }
        }
        
        
        
        return list;
    }
}