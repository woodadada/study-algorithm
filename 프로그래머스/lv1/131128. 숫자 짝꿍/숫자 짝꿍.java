import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String x, String y) {
        String answer = "";
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        int[] min = new int[10];
        int sum = 0;
        StringBuilder build = new StringBuilder();
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < x.length(); i++) {
                if (Character.getNumericValue(x.charAt(i)) == j) {
                    num1[j]++;
                }
            }
            for (int i = 0; i < y.length(); i++) {
                if (Character.getNumericValue(y.charAt(i)) == j) {
                    num2[j]++;
                }
            }
        }
        for (int j = 9; j >= 0; j--) {
            min[j] = Math.min(num1[j], num2[j]);
            for (int i = 0; i < min[j]; i++) {
                build.append(j);
            }
        }
        for (int i = 1; i < 10; i++) {
            sum += min[i];
        }
        answer = build.toString();
        if (answer.length() == 0) {
            answer = "-1";
        }
        if (min[0] != 0) {
            if (sum == 0)
                answer = "0";
        }

        return answer;
    }
}