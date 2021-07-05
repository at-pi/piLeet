class Solution {
    static class Node{
        char val;
        List<Node> list;
        Node(char x){
            this.val = x;
            this.list = new ArrayList<>();
        }
    }
    
    static private void createList(Node root, String str, int curr){
        if(curr>=str.length())
            return;
        boolean flag = false;
        Node temp = new Node('/');
        for(int i=0;i<root.list.size();i++){
            if(root.list.get(i).val==str.charAt(curr)){
                temp = root.list.get(i);
                //System.out.println("used same Node - "+temp.val);
                flag = true;
                break;
            }
        }
        if(flag==false){
            temp = new Node(str.charAt(curr));
            //System.out.println("create new Node - "+temp.val);
            root.list.add(temp);
        }
        
        
        createList(temp,str,curr+1);
    }
    
    static private void createListCaller(Node root, List<String> list){
        System.out.println("called createList Caller");
        for(int i=0;i<list.size();i++){
            //System.out.println("calling createList for - "+list.get(i));
            createList(root,list.get(i),0);
        }
    }
    
    static private void cutList(List<String> currList){
        Collections.sort(currList);
        while(currList.size()>3){
            currList.remove(currList.size()-1);
        }
    }
    
    static private void completeList(List<String> currList, Node root, String matchString,List<String> repository){
        //System.out.println("matchString- "+matchString);
        if(repository.contains(matchString)){
            if(!currList.contains(matchString))
                currList.add(matchString);
        }
            
        if(root.list.size()==0){
            if(!currList.contains(matchString))
                currList.add(matchString);
            return;
        }
        for(int i=0;i<root.list.size();i++){
            completeList(currList, root.list.get(i), matchString+root.list.get(i).val,repository);
        }
    }
    
    static private void check(List<List<String>> list, List<String> currList, Node root, String matchString, String searchString, int currChar, List<String> repository){
        boolean flag = false;
        int index = -1;
        for(int i=0;i<root.list.size();i++){
            if(searchString.charAt(currChar) == root.list.get(i).val){
                matchString+=searchString.charAt(currChar);
                flag = true;
                index = i;
                break;
            }
        }
        
        if(flag == false){
            list.add(new ArrayList<>());
            return;
        }
        
        
        else{
            //System.out.println("character found-"+root.list.get(index).val);
            if(currChar==searchString.length()-1){
                //System.out.println("searchString completed - "+matchString+" at index "+ currChar+" calling completeList");
                //System.out.println("currNode- "+root.list.get(index).val+" currNode size- "+root.list.get(index).list.size());
                completeList( currList, root.list.get(index), matchString, repository);
                cutList(currList);
                list.add(currList);
                return;
            }
            else{
                //System.out.println("calling check again");
                check(list, currList,root.list.get(index),matchString,searchString,currChar+1,repository);
            }
        }
        
    }
    
    static private void createReturnList(List<List<String>> list, Node root, String customerQuery, List<String> repository){
        //System.out.println("called createret list");
        int len = customerQuery.length();
        String curr = "";
        for(int i=0;i<len;i++){
            curr += customerQuery.charAt(i);
            if(curr.length()>=1){
                //System.out.println("called check for-"+curr);
                check(list, new ArrayList<>(), root, "", curr, 0, repository);
            }
        }
    }
    
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List<List<String>> list = new ArrayList<>();
        
        Node root = new Node('/');
        
        createListCaller(root,repository);
        
        createReturnList(list, root, customerQuery, repository);
        
        return list;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        return searchSuggestions(Arrays.asList(products),searchWord);
    }
}