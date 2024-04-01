import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String N;
    static int M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        M = Integer.parseInt(br.readLine());

        Stack<Character> keyStack = new Stack<>();
        Stack<Character> deleteStack = new Stack<>();
        for (int j = 0; j < N.length(); j++) {
            char c = N.charAt(j);
            keyStack.push(c);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            char c = s.charAt(0);
            if (c == 'L') {
                if (!keyStack.isEmpty()) {
                    deleteStack.push(keyStack.pop());
                }
            } else if (c == 'D') {
                if (!deleteStack.isEmpty()) {
                    keyStack.push(deleteStack.pop());
                }
            } else if (c == 'B') {
                if(!keyStack.isEmpty()) {
                    keyStack.pop();
                }
            } else if (c == 'P') {
                char addChar = st.nextToken().charAt(0);
                keyStack.push(addChar);
            }
        }

        while(!deleteStack.isEmpty()) {
            keyStack.push(deleteStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < keyStack.size(); k++) {
            sb.append(keyStack.get(k));
        }

        System.out.println(sb.toString());
    }
}