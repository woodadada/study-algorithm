class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long m = x;
        for (int i = 0; i < n; i++) {
            answer[i] = m * (i + 1);
        }
        return answer;
    }
}