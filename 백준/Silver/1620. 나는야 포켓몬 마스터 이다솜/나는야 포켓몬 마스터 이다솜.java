import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도감 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 질문 수

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, i + 1);
            arr[i] = s;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.matches("^\\d+$")) {
                int number = Integer.parseInt(s);
                sb.append(arr[number - 1]).append("\n");
            } else {
                sb.append(map.get(s)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}