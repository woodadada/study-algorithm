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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map1.put(s, s);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            map2.put(s, s);
            if(map1.containsKey(s)) {
                set.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}