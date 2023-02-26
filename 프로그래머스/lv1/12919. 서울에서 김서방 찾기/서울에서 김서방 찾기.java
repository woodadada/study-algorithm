import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        String s = "김서방은 %d에 있다";
        return String.format(s, Arrays.asList(seoul).indexOf("Kim"));
    }
}