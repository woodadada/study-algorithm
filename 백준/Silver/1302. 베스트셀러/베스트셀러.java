import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int max = 0;
        Map<Integer, List<String>> map1 = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
            map1.putIfAbsent(entry.getValue(), new ArrayList<>());
            map1.get(entry.getValue()).add(entry.getKey());
        }
        
        List<String> list = map1.get(max);
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}