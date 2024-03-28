import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
        System.out.println(visited[K] - 1);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            start = queue.poll();

            if(start == K) break;
            // 순간이동은 소모 시간이 0
            if(start * 2 <= 100000 && visited[start * 2] == 0) {
                visited[start * 2] = visited[start];
                queue.offer(start * 2);
            }
            if(start - 1 >= 0 && visited[start - 1] == 0) {
                visited[start - 1] = visited[start] + 1;
                queue.offer(start - 1);
            }

            if(start + 1 <= 100000 && visited[start + 1] == 0) {
                visited[start + 1] = visited[start] + 1;
                queue.offer(start + 1);
            }

            
        }
    }
}