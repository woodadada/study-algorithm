class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int temp = 0;
            temp = n / a * b;
            answer += temp;
            temp += n % a;
            n = temp;
        }
        return answer;
    }
}