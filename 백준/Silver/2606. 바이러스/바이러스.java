import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 인접 리스트 세팅
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs();
    }

    public static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;
        int count = 0;

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();

            for (Integer node : list.get(pop)) {
                if(!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}