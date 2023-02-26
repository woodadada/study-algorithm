import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = String.valueOf(n);
        String[] split = s.split("");
        answer = Arrays.stream(split).mapToInt(Integer::parseInt).sum();

        return answer;
    }
}