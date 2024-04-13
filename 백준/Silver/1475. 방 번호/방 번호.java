import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            String index = split[i];
            arr[Integer.parseInt(index)]++;
        }
        int max = 0;
        int max69 = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, arr[i]);
            } else {
                max69 += arr[i];
            }
        }
        max69++; // 2로 나누어 떨어지지 않는 경우 고려
        max69 /= 2; // 6, 9는 서로 대체 가능해서 나누기 
        System.out.println(Math.max(max, max69));
    }
}