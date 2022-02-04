class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9._-]","");
        new_id = new_id.replaceAll("[.]+",".");
        new_id = new_id.replaceAll("^[.]|[.]$","");
        if(new_id.equals("")){
            new_id = "a";
        }
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15).replaceAll("[.]+$","");
        }
        if(new_id.length()<=2){
            char[] charArray = new_id.toCharArray();
            sb.append(charArray);
            while(sb.length()<3){
                sb.append(charArray[charArray.length-1]);
            }
            new_id = sb.toString();
        }
        answer = new_id;
        return answer;
    }
}

