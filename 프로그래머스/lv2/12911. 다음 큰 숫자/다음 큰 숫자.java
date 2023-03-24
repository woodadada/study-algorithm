class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int count = Integer.bitCount(n);
        for(int i = n + 1; i <= 1000000; i++) {
            int iCount = Integer.bitCount(i);
            
            if(count == iCount) {
                return i;
            }
        }
        return answer;
    }
}