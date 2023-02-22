import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[][] numArrays = new int[num_list.length][2];
        for (int i = 0; i < num_list.length; i++) {
            numArrays[i][0] = num_list[i];
            numArrays[i][1] = Math.abs(n - num_list[i]);
        }

        Arrays.sort(numArrays, (o1, o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        int[] answer = new int[num_list.length];
        for (int i = 0; i < numArrays.length; i++) {
            int[] numArray = numArrays[i];
            answer[i] = numArray[0];
        }
        return answer;
    }
}