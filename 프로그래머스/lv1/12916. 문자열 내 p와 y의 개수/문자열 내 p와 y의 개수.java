class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] split = s.split("");

        int countP = 0, countY = 0;
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if(s1.toUpperCase().equals("P")) countP++;
            if(s1.toUpperCase().equals("Y")) countY++;
        }
        answer = countP == countY ? true : false;

        return answer;
    }
}