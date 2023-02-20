class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("answer = " + answer);
            while(answer % 3 == 0 || answer % 10 == 3 || answer / 10 == 3 || answer / 10 == 13){
                answer++;
            }
            answer++;
        }
        System.out.println("answer = " + answer);

        return answer - 1;
    }
}