class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        // a ~ z -> 0 ~ 25개 아스키 코드 97 ~ 122
        char[] chars = s.toCharArray();
        // 이동할 횟수
        for (char aChar : chars) {
            int count = 0;
            for (int i = 0; i < index; i++) {
                count++;
                // a - z 를 벗어나면 다시 a부터 시작하도록 26을 뺸다
                if(aChar + count > 122) {
                    count -= 26;
                }
                // skip 문자열에 포함된다면 한번 더 반복문을 실행
                if(skip.contains(String.valueOf((char) (aChar + count)))) {
                    i--;
                }
            }
            sb.append((char) (aChar + count));
        }
        return sb.toString();
    }
}