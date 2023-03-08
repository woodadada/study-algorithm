import java.util.Arrays;
import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            int[] ints = board[i];
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
        System.out.println("=======================");

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            for (int j = 0; j < board.length; j++) {
                int[] ints = board[j];
                int doll = ints[move - 1];
                if(doll != 0){
                    if(!bucket.isEmpty()){
                        if(bucket.peek() == doll){
                            bucket.pop();
                            System.out.println("bucket = " + bucket);
                            System.out.println("doll = " + doll);
                            answer++;
                            answer++;
                        }else{
                            bucket.push(doll);
                        }
                    }else {
                        bucket.push(doll);
                    }
                    ints[move - 1] = 0;
                    break;
                }
            }
        }

        System.out.println(" ========================= ");
        for (int i = 0; i < board.length; i++) {
            int[] ints = board[i];
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
        System.out.println("bucket = " + bucket);
        System.out.println("answer = " + answer);

        return answer;

    }
}