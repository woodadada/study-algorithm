class Solution {
    public String solution(String new_id) {
        String answer = "";
        System.out.println("new_id = " + new_id);
        new_id = new_id.toLowerCase();
        System.out.println("new_id = " + new_id);
        new_id = new_id.replaceAll("[^a-z0-9_.-]", "");
        System.out.println("new_id = " + new_id);
        new_id = new_id.replaceAll("\\.+", ".");
        System.out.println("new_id = " + new_id);
        new_id = new_id.replaceAll("^\\.", "");
        System.out.println("new_id = " + new_id);
        new_id = new_id.replaceAll("\\.$", "");
        System.out.println("new_id = " + new_id);

        if(new_id.isEmpty()){
            new_id = "a";
        }
        System.out.println("new_id = " + new_id);
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        System.out.println("new_id = " + new_id);
        if(new_id.length() <= 2){
            String temp = new_id.substring(new_id.length() - 1);
            int i = 3 - new_id.length();
            for (int j = 0; j < i; j++) {
                new_id += temp;
            }
        }
        System.out.println("new_id = " + new_id);
        return new_id;
    }
}