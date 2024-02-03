class Solution {
    public String solution(String s) {
        String answer = "";
        String arr[] = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        
        for(String str : arr){
            
            if(flag){
                sb.append(str.toUpperCase());
            }else{
                sb.append(str);
            }
            
            if(" ".equals(str)){
                flag = true;
            }else{
                flag = false;
            }
        }
        return sb.toString();
    }
}