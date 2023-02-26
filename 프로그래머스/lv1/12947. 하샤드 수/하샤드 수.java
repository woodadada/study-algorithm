import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        return x % Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum() == 0 ? true : false;
    }
}