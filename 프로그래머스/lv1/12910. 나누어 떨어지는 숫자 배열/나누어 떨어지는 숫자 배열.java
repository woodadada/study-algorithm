import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int[] ints = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        return ints.length == 0 ? new int[] {-1} : ints;
    }
}