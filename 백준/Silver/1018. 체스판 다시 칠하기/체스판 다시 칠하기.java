import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 64;
        String[][] arr = new String[N][M];
        // 2차원 배열 값 세팅
        for (int i = 0; i < arr.length; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = split[j];
            }
        }

        // 2차원 배열 순회 하면서 8 * 8 크기의 체스판 색상 체크
        int endN = N - 7; // 세로 줄 마지막 시작 지점
        int endM = M - 7; // 가로 줄 마지막 시작 지점
        for (int i = 0; i < endN; i++) {
            for (int j = 0; j < endM; j++) {
                count = Math.min(count, check(i, j, arr));
            }
        }

        System.out.println(count);
    }
    public static int check(int row, int col, String[][] arr) {

        int count = 0;
        // 시작 지점 색상
        String now = arr[row][col];

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if (now.equals(arr[i][j])) {
                   count++;
                }

                if (now.equals("W")) {
                    now = "B";
                } else {
                    now = "W";
                }
            }

            if (now.equals("W")) {
                now = "B";
            } else {
                now = "W";
            }
        }

        count = Math.min(count, 64 - count);
        return count;
    }
}