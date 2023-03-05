class Solution {
    public String solution(String s, String skip, int index) {
        // a ~ z -> 0 ~ 25 97 ~ 122
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char[] eChars = skip.toCharArray(); // 제외

        for (char ch : chars) {
            int count = 0;
            char target = ch;
            for (int i = 0; i < index; i++) {
                count++;
                if(target + count > 122){
                    count -= 26;
                }
                if(skip.contains(String.valueOf((char)(target + count)))){
                    i--;
                }
            }
            sb.append((char) (target + count));
        }

        System.out.println("sb = " + sb);

        return sb.toString();
    }
}