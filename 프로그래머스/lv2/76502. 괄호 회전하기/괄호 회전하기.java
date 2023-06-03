import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        // 입력 받은 괄호 회전 처리
        int length = s.length();
        for (int i = 0; i < length; i++) {
            s = s.substring(1, length) + s.substring(0, 1);
            if(check(s)) answer++;
        }
        return answer;
    }
    
    // 회전한 괄호 stack으로 닫히는 괄호 언어인지 체크
    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            } else {
                // 없다면 바로 return
                if(stack.isEmpty()) return false;
                // 조건에 맞는 괄호 문자 체크
                if(c == '}') {
                    if(stack.pop() != '{') return false;
                } else if (c == ']') {
                    if(stack.pop() != '[') return false;
                } else {
                    if(stack.pop() != '(') return false;
                }
            }
        }
        return true;
    }
}