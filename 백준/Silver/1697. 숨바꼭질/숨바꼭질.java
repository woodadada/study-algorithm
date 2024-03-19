import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int count = Integer.MAX_VALUE;
    public static int N, K;
    public static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        bfs(N);

        System.out.println(visited[K] - 1);

    }
    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = 1;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(poll == K) {
                break;
            }

            if(poll - 1 >= 0 && visited[poll - 1] == 0) {
                visited[poll - 1] = visited[poll] + 1;
                queue.offer(poll - 1);
            }
            if(poll + 1 <= 100000 && visited[poll + 1] == 0) {
                visited[poll + 1] = visited[poll] + 1;
                queue.offer(poll + 1);
            }
            if(poll * 2 <= 100000 && visited[poll * 2] == 0) {
                visited[poll * 2] = visited[poll] + 1;
                queue.offer(poll * 2);
            }

        }
    }
}