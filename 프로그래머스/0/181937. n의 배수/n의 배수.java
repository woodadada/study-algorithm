class Solution {
    public int solution(int num, int n) {
        int temp = num % n; 
        int answer = temp == 0 ? 1 : 0;
        return answer;
    }
}