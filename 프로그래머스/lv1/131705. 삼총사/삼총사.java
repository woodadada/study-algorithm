class Solution {
    public int solution(int[] number) {
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            int i1 = number[i];
            for (int j = i + 1; j < number.length; j++) {
                int i2 = number[j];
                for (int k = j + 1; k < number.length; k++) {
                    int i3 = number[k];
                    if((i1 + i2 + i3) == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}