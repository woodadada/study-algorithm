import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            if((score.length - i) % m == 0){
                answer += score[i] * m;
            }
        }
        return answer;
    }
}