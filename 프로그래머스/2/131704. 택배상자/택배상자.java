import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> subContainer = new Stack<>();

        int nowOrderIndex = 0;
        int count = 0;
        for (int i = 1; i <= order.length; i++) {
            // order 개수만큼 돌면서 순서가 아니면 subContainer에 넣기
            if (i != order[nowOrderIndex]) {
                subContainer.push(i);
//                System.out.println("subContainer = " + subContainer);
                continue;
            }

            nowOrderIndex++; // 다음 택배 박스 확인
            count++; // 개수 추가
            while(!subContainer.isEmpty() && subContainer.peek() == order[nowOrderIndex]) {
                subContainer.pop();
                nowOrderIndex++;
                count++;

//                System.out.println(subContainer);
            }
        }
        return count;
    }
}