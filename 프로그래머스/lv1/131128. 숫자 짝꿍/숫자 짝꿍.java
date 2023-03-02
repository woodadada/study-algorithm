import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        int[] countTwin = new int[10];
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        String answer = "";

        for (int i = 0; i < countX.length; i++) {
            for (int j = 0; j < X.length(); j++) {
                if(Character.getNumericValue(X.charAt(j)) == i){
                    countX[i]++;
                }
            }
            for (int j = 0; j < Y.length(); j++) {
                if(Character.getNumericValue(Y.charAt(j)) == i){
                    countY[i]++;
                }
            }
        }
        for (int i = countTwin.length - 1; i >= 0 ; i--) {
            countTwin[i] = Math.min(countX[i], countY[i]);
            sum += countTwin[i];
            for (int j = 0; j < countTwin[i]; j++) {
                sb.append(i);
            }
        }
        if(countTwin[0] != 0 && sum - countTwin[0] == 0) return "0";
        if(sum == 0) return "-1";
        
        return sb.toString();
    }
}