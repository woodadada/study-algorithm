class Solution {
    public int solution(int[] numbers) {
        // 1 ~ 9 까지의 합인 45에서 numbers의 합을 빼주도록 한다.
        int answer = 45;
        
        for(int number : numbers) {
            answer -= number;
        }    
        
        return answer;
    }
}