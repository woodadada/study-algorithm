import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long A, B;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long result = bfs();

        System.out.println(result);
    }

    public static long bfs() {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {A, 1}); // 시작 숫자, count

        while(!queue.isEmpty()) {
            long[] node = queue.poll();
            long num = node[0];
            long count = node[1];

            if(num > B) continue;

            if(num == B) {
                return count;
            }

            for (int i = 1; i <= 2; i++) {
                if(i == 1) {
                    queue.offer(new long[] {num * 2, count + 1});
                } else {
                    queue.offer(new long[] {num * 10 + 1, count + 1});
                }
            }
        }
        return -1;
    }
}