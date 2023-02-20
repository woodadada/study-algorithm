import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int gcd = getGCD(a, b);
        b /= gcd;

        while(b > 1){
            if(b % 2 == 0){
                b /= 2;
            }else if(b % 5 == 0){
                b /= 5;
            }else{
                return 2;
            }
        }
        
        return answer;
    }
    public static int getGCD(int num1, int num2){
        if(num1 % num2 == 0){
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}