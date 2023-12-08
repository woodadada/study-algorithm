import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>(); 
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            set.add(num % 42);
        }
        System.out.println(set.size());
    }
}