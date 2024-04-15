import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int[] arr = new int[k + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < k + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            changeSwitch(gender, num, arr);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
            if(i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static void changeSwitch(int gender, int num, int[] arr) {
        if (gender == 1) { // 남자 num 배수 스위치 상태 변환
            int plus = num;
            while(num < arr.length) {
                changeToggle(num, arr);
                num += plus;
            }
        } else { // 여자
            changeToggle(num, arr); // 일단 num 위치 변환
            int left = num - 1;
            int right = num + 1;
            while(left >= 1 && right <= k) {
                if(arr[left] == arr[right]) { // 대칭일 때 변환
                    changeToggle(left, arr);
                    changeToggle(right, arr);
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
    }

    static void changeToggle(int num, int[] arr) {
        arr[num] = arr[num] == 1 ? 0 : 1;
    }
}