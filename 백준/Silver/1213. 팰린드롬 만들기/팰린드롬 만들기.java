import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alphabet = new int[26];
        // 글자 수 카운팅
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'A';
            alphabet[index]++;
        }

        int oddCount = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] % 2 != 0) oddCount++;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder front = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder end = new StringBuilder();
        // 홀수인 글자가 1개 이상이면 펠린드롬 문자열을 못 만든다
        if(oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            // frond
            for (int i = 0; i < alphabet.length; i++) {
                // 알파벳의 절반만 붙인다
                for (int j = 0; j < alphabet[i] / 2; j++) {
                    front.append((char)(i + 65));
                }
            }
            result.append(front);

            // mid 홀수개를 가지는 알파벳을 담는다 (대칭 중간 점에 하나)
            for (int i = 0; i < alphabet.length; i++) {
                if(alphabet[i] % 2 == 1) {
                    mid.append((char)(i + 65));
                }
            }
            result.append(mid);
            // end
            end = front.reverse();
            result.append(end);
        }
        System.out.println(result);
    }
}