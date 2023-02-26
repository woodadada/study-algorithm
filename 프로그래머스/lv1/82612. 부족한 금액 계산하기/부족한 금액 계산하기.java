class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long m = money;
        long p = price;
        long temp = 0;
        for(int i = 0; i < count; i++){
            temp += p * (i + 1);
        }
        
        return temp > money ? Math.abs(temp - m) : 0; 
    }
}