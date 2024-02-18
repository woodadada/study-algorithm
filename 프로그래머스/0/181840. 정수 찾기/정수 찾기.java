import java.util.Arrays;

class Solution {
    public int solution(int[] num_list, int n) {
        boolean empty = Arrays.stream(num_list).filter(num -> num == n).findFirst().isPresent();
        int answer = empty ? 1 : 0;
        return answer;
    }
}