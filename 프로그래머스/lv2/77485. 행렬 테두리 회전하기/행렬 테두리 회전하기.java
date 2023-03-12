import java.util.Arrays;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arrays = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arrays[i][j] = (i  * columns + (j + 1));
            }
        }
        int index = 0;
        for (int[] query : queries) {
            // System.out.println("Arrays.toString(query) = " + Arrays.toString(query));
            int x1 = query[0] - 1; // 행
            int y1 = query[1] - 1; // 열
            int x2 = query[2] - 1; // 행
            int y2 = query[3] - 1; // 열
            int small; // 가장 작은 수

            int temp = arrays[x1 + 1][y1]; // 시작점 반시계 반향 한칸
            small = temp;
            int swap;

            // 시계 방향
            // 옆으로 밀기 2,2,5,4  2 ~ 4 까지 밀기
            for (int i = y1; i <= y2; i++) {
                swap = arrays[x1][i];
                arrays[x1][i] = temp;
                temp = swap;
                small = Math.min(small, temp);
            }

            // 아래로 밀기 2,2,5,4 3행 y2 부터 5행 y2까지
            for (int i = x1 + 1; i <= x2; i++) {
              swap = arrays[i][y2];
              arrays[i][y2] = temp;
              temp = swap;
              small = Math.min(small, temp);
            }

            // 밑 칸 왼쪽으로 밀기 2,2,5,4 y2-1 부터 왼쪽으로 y1 까지
            for (int i = y2 - 1; i >= y1; i--) {
                swap = arrays[x2][i];
                arrays[x2][i] = temp;
                temp = swap;
                small = Math.min(small, temp);
            }

            // 왼쪽 칸 위로 밀기 2.2,5,4 x2 - 1부터 위로 x1까지
            for (int i = x2 - 1; i >= x1; i--) {
                swap = arrays[i][y1];
                arrays[i][y1] = temp;
                temp = swap;
                small = Math.min(small, temp);
            }
            // System.out.println("small = " + small);
            // for (int i = 0; i < rows; i++) {
            //     System.out.println("i = " + Arrays.toString(arrays[i]));
            // }
            answer[index] = small;
            index++;
        }

        return answer;
    }
}