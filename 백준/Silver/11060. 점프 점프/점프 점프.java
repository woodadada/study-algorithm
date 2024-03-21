import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] arr;
    public static boolean[] visited;
    public static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 미로 초기화
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(0));
    }
    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, arr[start], 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nowIndex = temp[0];
            int jump = temp[1];
            int count = temp[2];

//            System.out.println("nowIndex = " + nowIndex);
//            System.out.println("visited = " + Arrays.toString(visited));
//            System.out.println("jump = " + jump);

            if(nowIndex == N-1) return count;

            for (int i = 1; i <= jump; i++) {
                int nextIndex = nowIndex + i;
                if(nextIndex >= N || visited[nextIndex]) continue;

                visited[nextIndex] = true;
                queue.offer(new int[]{nextIndex,arr[nextIndex],count+1});
            }
        }
        return -1;
    }
}