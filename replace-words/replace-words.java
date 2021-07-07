class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] arr = sentence.split(" ");
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<dictionary.size();j++){
                if(arr[i].indexOf(dictionary.get(j))==0){
                    arr[i] = dictionary.get(j);
                }
            }
        }
        sentence = "";
        for(int i=0;i<arr.length;i++){
            String temp = arr[i];
            if(i!=arr.length-1)
                sentence+=temp+" ";
            else
                sentence+=temp;
        }
        sentence.trim();
        return sentence;
    }
}