import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String upperCase = s.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        char[] ar = upperCase.toCharArray();
        int max = 0;
        for (char c : ar) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            max = Math.max(max, count);
        }

        int ch = 0;
        String answer = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(max == value) {
                ch++;
                answer = entry.getKey().toString();
            }
        }
        if(ch > 1) {
            answer = "?";
        }

        System.out.println(answer);
    }
}