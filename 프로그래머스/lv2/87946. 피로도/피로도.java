import java.util.*;
class Solution {
    private static boolean[] isVisit;
    private static List<Integer> list = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {
        isVisit = new boolean[dungeons.length];
        dfs(k, dungeons, isVisit, 0);
        list.sort(Comparator.reverseOrder());

        return list.get(0);
    }
    
    public static void dfs(int k, int[][] dungeons, boolean[] visited, int count) {

        for (int i = 0; i < dungeons.length; i++) {
            if(!isVisit[i] && k >= dungeons[i][0]) {
                isVisit[i] = true;
                dfs(k - dungeons[i][1], dungeons, isVisit, count+1);
                isVisit[i] = false;
            }
        }
        list.add(count);
    }
}