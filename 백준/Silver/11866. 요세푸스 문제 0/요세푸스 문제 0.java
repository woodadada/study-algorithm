import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            index++;

            if(index == K) {
                index = 0;
                sb.append(poll).append(", ");
            } else {
                queue.add(poll);
            }
        }
        sb = sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}