import java.util.Arrays;
class Solution {
    public int solution(String dartResult) {
        int[] array = new int[3];
        String point = "";
        int index = 0;

        char[] chars = dartResult.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(Character.isDigit(c)){
                point += String.valueOf(c);
            }else{
                if(c == 'S'){ // 1제곱
                    array[index] = (int) Math.pow(Integer.valueOf(point), 1);
                    index++;
                    point = "";
                }else if(c == 'D'){ // 2제곱
                    array[index] = (int) Math.pow(Integer.valueOf(point), 2);
                    index++;
                    point = "";
                }else if(c == 'T'){ // 3제곱
                    array[index] = (int) Math.pow(Integer.valueOf(point), 3);
                    index++;
                    point = "";
                }else if(c == '*'){ // 바로 전과 전전에 얻은 점수 각 2배
                    array[index - 1] *= 2;
                    if(index > 1){
                        array[index - 2] *= 2;
                    }
                }else if(c == '#'){ // 해당 점수 마이너스
                    array[index - 1] *= -1;
                }
            }
        }
        System.out.println("arrays.to = " + Arrays.toString(array));
        int sum = Arrays.stream(array).sum();
        System.out.println("sum = " + sum);
        return sum;
    }
}