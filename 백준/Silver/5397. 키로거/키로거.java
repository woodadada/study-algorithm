import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> keyStack = new Stack<>();
            Stack<Character> deleteStack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '<') {
                    if (!keyStack.isEmpty()) {
                        deleteStack.push(keyStack.pop());
                    }
                } else if (c == '>') {
                    if (!deleteStack.isEmpty()) {
                        keyStack.push(deleteStack.pop());
                    }
                } else if (c == '-') {
                    if(!keyStack.isEmpty()) {
                        keyStack.pop();
                    }
                } else {
                    keyStack.push(c);
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
}