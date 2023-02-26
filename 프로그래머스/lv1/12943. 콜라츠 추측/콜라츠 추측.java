class Solution {
    public int solution(int num) {
        
        long n = num;
        int answer = -1;
        for (int i = 0; i < 500; i++) {
            if(n == 1) {
                answer = i;
                break;
            }

            if(n % 2 == 0){
                n /= 2;
            }else{
                n = n * 3 + 1;
            }

        }
        return answer;
    }
}