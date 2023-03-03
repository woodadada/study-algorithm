class Solution {
    public int solution(int number, int limit, int power) {
        int[] array = new int[number];

        // 약수 갯수 구하기
        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j <= (int)Math.sqrt(i); j++) {
                if(i % j == 0){
                    count++;
                    if(i / j != j){
                        count++;
                    }
                }
            }
            array[i-1] = count;
        }
        int sum = 0;
        for (int i : array) {
            if(i > limit){
                sum += power;
            }else{
                sum += i;
            }
        }

        return sum;
    }
}