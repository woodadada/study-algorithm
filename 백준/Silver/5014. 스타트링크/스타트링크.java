import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F+1]; // 건물 층수 방문 여부

        int bfs = bfs(new int[]{S, 1});
        if(bfs == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(bfs - 1);
        }
    }

    public static int bfs(int[] node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            node = queue.poll();
            int now = node[0];
            int count = node[1];

            if(G == now) {
                return count;
            }

            for (int i = 0; i < 2; i++) {
                if(i == 0) {
                    // up
                    int up = now + U;
                    if(up <= F && !visited[up]) {
                        queue.offer(new int[] {up, count + 1});
                        visited[up] = true;
                    }

                } else {
                    // down
                    int down = now - D;
                    if(down >= 1 && !visited[down]) {
                        queue.offer(new int[] {down, count + 1});
                        visited[down] = true;
                    }
                }
            }
        }

        return -1;
    }
}