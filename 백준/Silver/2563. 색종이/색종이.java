import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] paper = new int[100][100];
        final int SIZE = 10;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            for (int j = row; j < row + SIZE; j++) {
                for (int k = col; k < col + SIZE; k++) {
                    paper[j][k] = 1;
                }
            }
        }
        int count = 0;
        for (int[] ints : paper) {
            for (int i : ints) {
                count += i;
            }
        }
        System.out.println(count);
    }
}