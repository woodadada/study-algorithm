import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        long bfs = bfs();
        System.out.println(bfs);
    }

    static long bfs() {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {A, 1});

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            long num = poll[0];
            long count = poll[1];

            // 탈출 조건
            if(num == B) return count;
            // 무시
            if(num > B) continue;

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    queue.offer(new long[] {num * 2, count + 1});
                } else { // 마지막 자리에 1 추가
                    queue.offer(new long[] {num * 10 + 1, count + 1});
                }
            }
        }
        return -1;
    }
}