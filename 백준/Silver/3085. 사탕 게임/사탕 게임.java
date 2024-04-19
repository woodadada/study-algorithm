import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                max = Math.max(max, search(n));
                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j);
                max = Math.max(max, search(n));
                swap(i, j, i + 1, j);
            }
        }
        System.out.println(max);
    }
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    static int search(int n) {
        int max = 1;
        // 행 탐색
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if(map[i][j] == map[i][j + 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        // 열 탐색
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 0; j < n - 1; j++) {
                if(map[j][i] == map[j + 1][i])
                    count++;
                else
                    count = 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}