import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        List<Integer> nums = new ArrayList<>();
        int round = (int) Math.round(N * 0.15);

        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nums);

        int sum = 0;
        for (int i = round; i < nums.size() - round; i++) {
            sum += nums.get(i);
        }

        int result = Math.round(sum / (float)(N - round * 2));
        System.out.println(result);
    }
}