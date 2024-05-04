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
        int s = Integer.parseInt(st.nextToken()); // 3개 파
        int c = Integer.parseInt(st.nextToken()); // 5개의 파닭

        int left = 1;
        int right = 1_000_000_000;
        long sum = 0;
        int[] fa = new int[s];
        for (int i = 0; i < s; i++) {
            int length = Integer.parseInt(br.readLine()); // 1개의 파 길이
            fa[i] = length;
            sum += length;
        }

        while(left <= right) {
            int mid = (left + right) / 2; // 현재의 파 길이
            int count = 0; // 파닭을 만들 수 있는 개수
            for (int i = 0; i < s; i++) {
                count += fa[i] / mid;
            }

            // 파닭이 주문 수 보다 많이 만들어지면 파 길이를 늘린다.
            if(count >= c) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(sum - right * (long) c); // 라면에 넣을 파 길이 계산
    }
}