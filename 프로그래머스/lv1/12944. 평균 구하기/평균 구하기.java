import java.util.Arrays;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        return Arrays.stream(arr).average().getAsDouble();
    }
}