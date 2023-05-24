class Solution {
    int solution(int[][] land) {
        int length = land.length;
        // 두번째 행부터 누적 점수 합산
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][2], Math.max(land[i-1][0], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][3], Math.max(land[i-1][1], land[i-1][0]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][1]));
        }

        // 누적 점수 합산한 마지막 행에서 최대 값 추출
        int answer = 0;
        for (int i = 0; i < land[length - 1].length; i++) {
            answer = Math.max(land[length-1][i], answer);
        }
        return answer;
    }
}