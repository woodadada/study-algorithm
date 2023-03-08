class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 0; // 드래그 시작점
        int luy = 0;
        int rdx = 0; // 드래그 끝점
        int rdy = 0;

        boolean isFirst = false;
        for (int i = 0; i < wallpaper.length; i++) {
            String s = wallpaper[i];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(aChar == '#'){
                    if(!isFirst){ // 처음 세팅
                        lux = i;
                        luy = j;
                        rdx = i + 1;
                        rdy = j + 1;
                        isFirst = true;
                    }else{
                        luy = Math.min(luy, j);
                        rdx = Math.max(rdx, i + 1);
                        rdy = Math.max(rdy, j + 1);
                    }
                }
            }
        }
        return new int[] {lux, luy, rdx, rdy};
    }
}