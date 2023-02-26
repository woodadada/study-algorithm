import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if(stack.isEmpty()) stack.push(i1);
            else if(stack.peek() != i1) stack.push(i1);
        }
        answer = new int[stack.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}