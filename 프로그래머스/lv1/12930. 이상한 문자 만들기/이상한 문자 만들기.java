class Solution {
    public String solution(String s) {
        String[] s1 = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            char[] chars = s2.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(j % 2 == 0){
                    sb.append(Character.toUpperCase(aChar));
                }else if(j % 2 == 1){
                    sb.append(Character.toLowerCase(aChar));
                }else{
                    sb.append(" ");
                }
            }
            if(i != s1.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}