import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int i1 = 0; i1 < str.length(); i1++) {
                char c = str.charAt(i1);
                if (stack.isEmpty()) {
                   stack.add(c);
                } else {
                    if (c == ')') {
                        Character peek = stack.peek();
                        if (peek == '(') {
                            stack.pop();
                        }
                    } else {
                        stack.add(c);
                    }
                }
            }
            
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
            stack.clear();
        }

        System.out.println(sb.toString());
    }
}