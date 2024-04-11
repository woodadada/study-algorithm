import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            Integer poll = queue.poll();
            sb.append(poll).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}