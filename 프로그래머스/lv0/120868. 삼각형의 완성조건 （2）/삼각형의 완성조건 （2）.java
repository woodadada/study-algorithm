import java.util.Arrays;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int max = sides[sides.length - 1];
        int min = sides[0];

        int st = Math.abs(max - min);
        answer += max - st;
        
        int start = max;
        int end = max + min - 1;
        answer += (end - start);
        return answer;
    }
}