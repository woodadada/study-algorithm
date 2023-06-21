class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        // 토너먼트 횟수
        int cnt = n / 2;
        for (int i = 0; i <= cnt / 2; i++) {

            if((a % 2 == 0 && a - 1 == b) || (a % 2 != 0 && a + 1 == b)) {
                break;
            }

            // 짝수 체크
            if(a % 2 == 0) {
                a /= 2;
            } else {
                a = (a + 1) / 2;
            }

            if(b % 2 == 0) {
                b /= 2;
            } else {
                b = (b + 1) / 2;
            }

            answer++;
        }
        return answer;
    }
}