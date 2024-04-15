import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // <ab cd>ef gh<ij kl>
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        boolean hasStart = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '<') { // 시작 태그
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                hasStart = true;
                sb.append(c);
            } else if(hasStart && c == '>') {
                hasStart = false;
                sb.append(c);
            } else if(hasStart) {
                sb.append(c);
            } else {
                // 스택에 넣으면서
                if(c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}