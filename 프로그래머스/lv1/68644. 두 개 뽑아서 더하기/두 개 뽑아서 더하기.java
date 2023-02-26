import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int number1 = numbers[j];
                set.add(number + number1);
            }
        }
        int[] answer = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            answer[index] = integer;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}