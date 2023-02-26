class Solution {
    public int[] solution(int n, int m) {
        int min = 0;
        for (int i = 1; i < Math.max(n, m); i++) {
            if(n % i == 0 && m % i == 0) min = i;
        }
        int[] answer = {min, min * ((n / min) * (m / min))};
        return answer;
    }
}