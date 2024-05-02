import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int result = s.length();
        for (int i = 0; i < s.length(); i++) {
            if(isPalindrome(s.substring(i))) { // 펠린드롬 문자열 확인
                break;
            }
            result++;
        }
        System.out.println(result);
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}