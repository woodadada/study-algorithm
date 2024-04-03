import java.util.*;

class Solution {
    public String solution(String p) {
        return recursive(p);
    }
    
    public String recursive(String p) {
        if(p.isEmpty()) return "";
        int len = getLength(p);
        String u = p.substring(0, len); // 0~index
        String v = p.substring(len); // index~end

        if (isCorrectBracket(u)) { // 옮은 괄호인지 확인
            return u + recursive(v);
        } else {
            return "(" + recursive(v) + ")" + makeReverseBracket(u);
        }
    }

    public boolean isCorrectBracket(String u) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        return true;
    }

    public int getLength(String p) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if(left == right) {
                return i + 1;
            }
        }
        return p.length();
    }

    public String makeReverseBracket(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str.length() - 1; i++){
            char ch = str.charAt(i);
            if(ch == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}