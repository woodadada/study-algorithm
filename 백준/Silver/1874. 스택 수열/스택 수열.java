import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        int num = 1; // stack에 추가할 숫자

        for (int i = 0; i < n; i++) {
            // stack에 숫자 추가
            if (num <= arr[i]) {
                while(num <= arr[i]) {
                    stack.add(num);
                    num++;
                    sb.append("+").append("\n");
                }

                // 모두 추가 후 마지막 것은 pop
                stack.pop();
                sb.append("-").append("\n");
            } else {
                // 수열 숫자보다  stack 숫자가 크면 불가능
                if (arr[i] < stack.peek()) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}