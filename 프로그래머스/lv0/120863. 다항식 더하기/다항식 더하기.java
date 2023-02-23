class Solution {
    public String solution(String poly) {
        int num = 0;
        int xNum = 0;

        String[] split = poly.split(" \\+ ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            System.out.println("s = " + s);
            if(s.contains("x")){
                xNum += s.length() == 1 ? 1 : Integer.parseInt(s.replace("x", ""));
            }else{
                num += Integer.parseInt(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(num == 0 && xNum > 0){
            if(xNum == 1){
                sb.append("x");
            }else{
                sb.append(xNum + "x");
            }
        }else if(num > 0 && xNum >0){
            if(xNum == 1){
                sb.append("x").append(" + ").append(num);
            }else{
                sb.append(xNum + "x").append(" + ").append(num);
            }
        }else {
            sb.append(num);
        }
        return sb.toString();
    }
}