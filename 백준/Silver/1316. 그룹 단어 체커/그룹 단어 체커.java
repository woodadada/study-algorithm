import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(go(s)) count++;
        }
        System.out.println(count);
    }
    static boolean go(String str) {
        boolean[] check = new boolean[26]; // 알파벳 만큼 선언

        int prev = 0;

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if(prev != now) {
                if(!check[now - 'a']) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}