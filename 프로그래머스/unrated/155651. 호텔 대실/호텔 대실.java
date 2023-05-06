import java.util.*;
class Solution {
        public int solution(String[][] book_time) {
        // 입장 시간으로 정렬, 입장 시간이 같으면 퇴실 시간이 빠른 순
        PriorityQueue<Room> pq = new PriorityQueue<>((a, b) -> a.start ==  b.start ? a.end - b.end : a.start - b.start);
        for (String[] s : book_time) {
            pq.add(new Room(s[0], s[1]));
        }

        // 머무르는 사람, 퇴실 시간이 빠른 순으로 정렬
        PriorityQueue<Room> outPq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        outPq.add(pq.poll());

        while(!pq.isEmpty()) {
            Room in = pq.poll();
            Room out = outPq.peek();
            if(out.end <= in.start) {
                outPq.poll();
            }
            outPq.add(in);
        }
        return outPq.size();
    }

    public class Room{
        int start;
        int end;
        public Room(String start, String end) {
            String[] stSplit = start.split(":");
            String[] endSplit = end.split(":");
            this.start = Integer.valueOf(stSplit[0]) * 60 + Integer.valueOf(stSplit[1]);
            this.end = Integer.valueOf(endSplit[0]) * 60 + Integer.valueOf(endSplit[1]) + 10;
        }
    }
    
}