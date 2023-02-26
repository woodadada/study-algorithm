
import java.util.stream.LongStream;
import java.util.*;
class Solution {
    public long solution(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        long sum = LongStream.rangeClosed(min, max).sum();
        return sum;
    }
}