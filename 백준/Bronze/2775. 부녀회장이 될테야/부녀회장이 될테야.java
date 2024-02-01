import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 횟수
        int N = Integer.parseInt(br.readLine());
        // 0층 0, 1, 2, 3, 4, 5, 6, 7, 8
        // 1층 0, 1, 3, 6, 10, 15, 21, 28, 36
        // 2층 0, 1, 4, 10, 20, 35, 51, 79, 115
        // 3층 0, 1, 5, 15, 35, 70, 121, ...
        int roomNumber = 0;
        int floor = 0;
        for (int i = 0; i < N; i++) {
            floor = Integer.parseInt(br.readLine());
            roomNumber = Integer.parseInt(br.readLine());
            System.out.println(dp(floor-1, roomNumber));
        }
    }
    // dp 함수로 한층 아래의 누적합을 구한다.
    // 2층 3호의 답은 1층의 1,2,3호 거주 인원인 1명, 3명 6명의 합계인 10명
    // 2층 0, 1, 4, 10, 20
    // 1층 0, 1, 3, 6, 10
    // 0층 0, 1, 2, 3, 4
    public static int dp(int floor, int roomNumber) {
        int sum = 0;
        for (int i = 1; i < roomNumber + 1; i++) {
            if(floor > 0) {
                sum += dp(floor - 1, i);
            } else { // 0층은 roomNumber만큼 사람이 산다.
                sum += i;
            }
        }
        return sum;
    }
}