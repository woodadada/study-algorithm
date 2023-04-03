import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] s1 = s.split(" ");
        int max = Arrays.stream(s1).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(s1).mapToInt(Integer::parseInt).min().getAsInt();
        return min + " " + max;
    }
}