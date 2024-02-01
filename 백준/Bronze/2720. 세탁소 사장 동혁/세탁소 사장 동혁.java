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
        double[] coinArr = {0.25, 0.1, 0.05, 0.01};
        StringBuilder sb = new StringBuilder();
        // 거스름 돈 계산
        for (int i = 0; i < N; i++) {
            double pay = Double.parseDouble(br.readLine());
            pay = pay / 100;
            for (int j = 0; j < coinArr.length; j++) {
                int count = (int) (pay / coinArr[j]);
                pay %= coinArr[j];
                // 소수점 반올림 처리
                pay = Math.round(pay * 100) / 100.0;
                sb.append(count).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}