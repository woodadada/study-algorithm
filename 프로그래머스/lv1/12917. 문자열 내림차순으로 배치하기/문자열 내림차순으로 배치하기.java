import java.util.*;
class Solution {
    public String solution(String s) {
        String[] split = s.split("");
        Arrays.sort(split);
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            sb.append(s1);
        }
        sb.reverse();
        return sb.toString();
    }
}