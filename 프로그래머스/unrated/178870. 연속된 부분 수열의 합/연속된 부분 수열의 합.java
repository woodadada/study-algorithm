import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int partitionSum = sequence[0];
        int n = sequence.length;
        int minDist = Integer.MAX_VALUE;
        List<SubSequence> result = new ArrayList<>();

        while(true) {
            if(partitionSum == k) {
                result.add(new SubSequence(left, right));
                minDist = Math.min(minDist, right - left);
            }

            if(left == n && right == n) break;

            if(partitionSum <= k && right < n) {
                right++;
                // 위 라인에서 플러스 시키기 때문에 sequence index를 마지막에는 벗어남
                if(right < n) partitionSum += sequence[right];
            } else {
                if(left < n) partitionSum -= sequence[left];
                left++;
            }
        }

        int finalMinDist = minDist;
        List<SubSequence> collect = result.stream().filter(o -> o.getDistance() == finalMinDist).sorted(Comparator.comparing(SubSequence::getLeft)).collect(Collectors.toList());
        return new int[] {collect.get(0).getLeft(), collect.get(0).getRight()};
    }
    
    public class SubSequence {
        int left, right, distance;

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getDistance() {
            return distance;
        }

        public SubSequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.distance = right - left;
        }
    }
}