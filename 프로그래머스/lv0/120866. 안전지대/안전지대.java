import java.util.Arrays;
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            int[] num = board[i];

            for (int j = 0; j < num.length; j++) {
                if(num[j] == 1) {
                    newBoard[i][j] = 1;

                    if(i - 1 >= 0){
                        newBoard[i - 1][j] = 1; // 상
                        if(j + 1 < num.length){
                            newBoard[i - 1][j + 1] = 1; // 오른쪽 위 대각선
                        }
                        if (j - 1 >= 0) {
                            newBoard[i - 1][j - 1] = 1; // 왼쪽 위 대각선
                        }
                    }

                    if(j + 1 < num.length){
                        newBoard[i][j + 1] = 1; // 우
                    }

                    if (j - 1 >= 0) {
                        newBoard[i][j - 1] = 1; // 좌
                    }

                    if(i + 1 < board.length){
                        newBoard[i + 1][j] = 1; // 하
                        if(j + 1 < num.length){
                            newBoard[i + 1][j + 1] = 1; // 오른쪽 위 대각선
                        }
                        if (j - 1 >= 0) {
                            newBoard[i + 1][j - 1] = 1; // 왼쪽 아래 대각선
                        }
                    }
                }
            }
            // System.out.println("Arrays.toString(num) = " + Arrays.toString(num));
        }
        answer = (int)Arrays.stream(newBoard).flatMapToInt(arr -> Arrays.stream(arr)).filter(o -> o == 0).count();
        return answer;
    }
}