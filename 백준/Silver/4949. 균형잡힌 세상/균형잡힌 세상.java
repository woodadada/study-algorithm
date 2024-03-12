import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(".".equals(s)) break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true; // []][] 처림 닫히는 괄호 대응
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 소괄호 대괄호 stack에 넣기
                if(c == '(' || c == '[') {
                    stack.add(c);
                } else if(c == ')' || c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                }
            }

            if(!s.endsWith(".") || !stack.isEmpty()) {
                System.out.println("no");
            } else if(!flag){
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }

    }
}