class Solution {
    public int solution(int num, int n) {
        int temp = num % n; 
        boolean answer = temp == 0 ? true : false;
        return answer ? 1 : 0;
    }
}