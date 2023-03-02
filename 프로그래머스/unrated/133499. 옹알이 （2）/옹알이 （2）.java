import java.util.Arrays;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speak = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];
            for (String s1 : speak) {
                if (s.indexOf(s1 + s1) < 0){
                    babbling[i] = babbling[i].replace(s1, " ");
                }
            }
            babbling[i] = babbling[i].replace(" ", "");
            if("".equals(babbling[i])) answer++;
        }
        System.out.println("Arrays.toString(babbling) = " + Arrays.toString(babbling));

        System.out.println("answer = " + answer);
        return answer;
    }
}