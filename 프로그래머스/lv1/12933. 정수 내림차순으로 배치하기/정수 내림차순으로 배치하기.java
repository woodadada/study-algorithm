import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] split = String.valueOf(n).split("");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).sorted().toArray();
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            sb.append(i);
        }
        
        answer = Long.parseLong(String.valueOf(sb.reverse()));
        return answer;
    }
}