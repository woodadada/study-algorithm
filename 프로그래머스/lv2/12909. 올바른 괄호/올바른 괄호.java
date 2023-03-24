import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '('){
                stack.add(ch);
            } else {
              if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}