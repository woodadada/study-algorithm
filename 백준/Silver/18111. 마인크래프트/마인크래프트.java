import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int min = 256;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int resultTime = 999999999;
        int high = 0;

        // 블록 층 최소, 최대 값 사이 값만큼 for문
        for (int i = min; i <= max; i++) {
            int time = 0;
            int block = b;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 현재 층이 만들 층수보다 큰지 비교
                    if (i < arr[j][k]) { // 크면 블록을 제거, 블록 재고 추가, 시간 2초
                        time += ((arr[j][k] - i) * 2);
                        block += (arr[j][k] - i);
                    } else { // 낮은 경우 블록을 쌓기, 블록 재고 제거, 시간 1초
                        time += (i - arr[j][k]);
                        block -= (i - arr[j][k]);
                    }
                }
            }

            if (block < 0) break;

            if (resultTime >= time) {
                resultTime = time;
                high = i;
            }
        }
        System.out.println(resultTime + " " + high);

    }
}