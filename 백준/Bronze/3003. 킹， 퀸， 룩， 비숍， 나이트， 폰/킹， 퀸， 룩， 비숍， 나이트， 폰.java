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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 2);
        map.put(4, 2);
        map.put(5, 8);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            Integer rightCount = map.get(i);
            boolean flag = false;
            
            if (num < rightCount) flag = true;

            if(flag) {
                sb.append(rightCount - num).append(" ");
            } else {
                sb.append((num - rightCount) * -1).append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}