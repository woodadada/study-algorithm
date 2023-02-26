class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        if(s.length() % 2 == 0){
            int i = s.length() / 2 - 1;
            String s1 = String.valueOf(chars[i]) + String.valueOf(chars[i + 1]);
            return s1;
        }else{
            int i = s.length() / 2;
            String s1 = String.valueOf(chars[i]);
            return s1;
        }
    }
}