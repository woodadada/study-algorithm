import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int xIndex = 0;
        int yIndex = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[i] = length;

            if(direction == 1 || direction == 2) { // x축 가로
                maxX = Math.max(maxX, length);
                if(maxX == length) xIndex = i;
            }

            if(direction == 3 || direction == 4) { // y축 세로
                maxY = Math.max(maxY, length);
                if(maxY == length) yIndex = i;
            }
        }
        int bigBox = maxX * maxY;
        int smallBox = arr[(xIndex + 3) % 6] * arr[(yIndex + 3) % 6];
        System.out.println((bigBox - smallBox) * k);
    }
}