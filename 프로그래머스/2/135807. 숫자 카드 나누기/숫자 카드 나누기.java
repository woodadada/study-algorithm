class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int max = Math.max(arrayA[0], arrayB[0]);

        for (int i = 2; i <= max; i++) {
            if((dividing(arrayA, i) && notDividing(arrayB, i)) ||
                    (dividing(arrayB, i) && notDividing(arrayA, i))) {
                answer = i;
            }
        }
        return answer;
    }

    public static boolean dividing(int[] arr, int num) {
        for (int n : arr) {
            if(n % num == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public static boolean notDividing(int[] arr, int num) {
        for (int n : arr) {
            if(n % num != 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}