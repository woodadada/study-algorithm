import java.util.*;
class Solution {
    public int solution(int[][] dots) {
//         int answer = 0;
//         ArrayList<Double> list = new ArrayList<>(); // 기울기를 담을 배열
//         for (int i = 0; i < dots.length; i++) {
//             for (int j = i + 1; j < dots.length; j++) {
//                 double v = (double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]); // 각 선의 기울기
//                 list.add(v);
//             }
//         }
//         int count = 0;
//         // 0 5, 1, 4, 2, 3
//         for (int i = 0; i < 3; i++) {
//             Double aDouble = list.get(i);
//             Double aDouble1 = list.get(list.size() - i - 1);

//             if(aDouble.compareTo(aDouble1) == 0) count++;
//         }
        
//         if(count >= 2){
//             answer = 1;
//         }
//         return answer;
        int answer = 0;
        Double v = (double) (dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]);
        Double v1 = (double) (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0]);
        if(v.compareTo(v1) == 0) return 1;

        Double v2 = (double) (dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]);
        Double v3 = (double) (dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0]);
        if(v2.compareTo(v3) == 0) return 1;

        Double v4 = (double) (dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]);
        Double v5 = (double) (dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]);
        if(v4.compareTo(v5) == 0) return 1;

        return answer;
    }
}