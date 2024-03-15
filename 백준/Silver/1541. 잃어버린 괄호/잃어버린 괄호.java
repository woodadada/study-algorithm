import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("\\-");

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            String[] plusArr = str.split("\\+");

            int sum = 0;
            for (int i1 = 0; i1 < plusArr.length; i1++) {
                sum += Integer.parseInt(plusArr[i1]);
            }

            if(answer == Integer.MAX_VALUE) { // 처음 숫자가 양수인지 확인
                answer = sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}