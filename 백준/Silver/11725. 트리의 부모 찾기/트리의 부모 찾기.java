import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visited;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        parents = new int[N + 1];
        
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        // 연결 노드 값 세팅
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        bfs(1);
        // 노드 부모 출력
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            Integer num = queue.poll();
            for (Integer node : list.get(num)) { // 연결 노드 추출
                if(!visited[node]) {
                    visited[node] = true; // 방문처리
                    parents[node] = num;
                    queue.offer(node);
                }
            }
        }
    }
}