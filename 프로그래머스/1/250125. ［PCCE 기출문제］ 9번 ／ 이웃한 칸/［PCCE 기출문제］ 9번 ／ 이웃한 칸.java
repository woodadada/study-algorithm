class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0}; // 세로 이동
        int[] dw = {1, 0, 0, -1}; // 가로 이동
        String now = board[h][w];

        System.out.println("now = " + now);
        for (int i = 0; i <= 3; i++) {
            // 동서남북 범위 체크
            if(h + dh[i] < 0 || board.length <= h + dh[i]) {
                continue;
            }
            if (w + dw[i] < 0 || board[0].length <= w + dw[i]) {
                continue;
            }
            
            String move = board[h + dh[i]][w + dw[i]];
            if (now.equals(move)) {
               answer++;
            }

        }
        return answer;
    }
}