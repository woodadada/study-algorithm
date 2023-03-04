class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        int sCnt = 1; // 같은 문자 카운트
        int dCnt = 0; // 다른 문자 카운트
        Character standard = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            if(standard.equals('-')){
                standard = aChar;
                continue;
            }
            if(standard.equals(aChar)){
                sCnt++;
            }else{
                dCnt++;
            }

            if(sCnt == dCnt){
                System.out.println("aChar = " + aChar);
                standard = '-';
                sCnt = 1;
                dCnt = 0;
                answer++;
            }
        }
        if(!standard.equals('-')) answer++;
        return answer;
    }
}