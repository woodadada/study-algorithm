import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] user = new int[N + 1];
        int[] count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            user[i] = 0;
            count[i] = 0;
        }

        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            count[stage - 1] += 1;

            for (int j = 1; j <= N; j++) {
                if(j <= stage){
                    user[j - 1] += 1;
                }
            }
        }

        System.out.println("user = " + Arrays.toString(user));
        System.out.println("count = " + Arrays.toString(count));
//        int[][] test = new int[5][2];
//        System.out.println("Arrays.deepToString(test) = " + Arrays.deepToString(test));
        
//        double[] fail = new double[N + 1];
        double[][] fail = new double[N][2];
        for (int i = 0; i < N; i++) {
            fail[i][0] = (double) i + 1;
            if(count[i] != 0 && user[i] != 0){
                fail[i][1] = (double) count[i] / user[i];
            }
        }
        System.out.println("fail = " + Arrays.deepToString(fail));
//        Arrays.sort(fail, Comparator.comparingDouble(v -> v[1]).reversed());
//        Arrays.sort(fail, (o1, o2) -> Double.compare(o2[1], o1[1]));


Arrays.sort(fail, (o1, o2) -> Double.compare(o2[1], o1[1]));
        // Arrays.sort(fail, Comparator.<double[]>comparingDouble(a -> a[1]).reversed().thenComparingDouble(a -> a[0]));
        System.out.println("fail = " + Arrays.deepToString(fail));
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int)fail[i][0];
        }
        System.out.println("answer = " + Arrays.toString(answer));


        return answer;
    }
}