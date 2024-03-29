import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    dfs(new Node(i, j));
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        visited[node.row][node.col] = true;

        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            int row = pop.row;
            int col = pop.col;
            char c = map[row][col];
            boolean isDash = false;
            if(c == '-') isDash = true;

            if(isDash) {
                if (col + 1 < M && !visited[row][col + 1] && map[row][col + 1] == c) {
                    visited[row][col + 1] = true;
                    stack.push(new Node(row, col + 1));
                }
            } else {
                if (row + 1 < N && !visited[row + 1][col] && map[row + 1][col] == c) {
                    visited[row + 1][col] = true;
                    stack.push(new Node(row + 1, col));
                }
            }
        }
    }
}