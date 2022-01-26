import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userCount = id_list.length;
        int[] answer = new int[userCount];
        User[] user_list = new User[userCount];
        HashMap<String, Integer> declaration = new HashMap<>();

        for(int i=0; i<userCount; i++){    // user 정보 받기
            user_list[i] = new User(id_list[i]);
            declaration.put(id_list[i],0);
        }

        for(int i=0;i<report.length;i++){       // 신고 처리
            String[] str = report[i].split("\\s");
            for(User user : user_list){
                if(user.getId().equals(str[0])){
                    if(!user.checkDeclaration(str[1])) {
                        user.declare(str[1]);
                        declaration.put(str[1], declaration.get(str[1]) + 1);
                    }
                    break;
                }
            }
        }

        LinkedList<String> ban_list = new LinkedList<>();  // ban 대상 결정
        for(Map.Entry<String, Integer> entry : declaration.entrySet()){
            if(entry.getValue()>=k){
                ban_list.add(entry.getKey());
            }
        }

        int index = 0;
        for(User user : user_list){     // ban 대상 메일 보내기
            int banResult = 0;
            for(String id : ban_list){
                if(user.checkDeclaration(id)) {
                    banResult++;
                }
            }
            answer[index++] = banResult;
        }
        
        
        return answer;
    }
}

class User {
    private String id;
    private LinkedList<String> declarationId;

    User(String _id){
        id = _id;
        declarationId = new LinkedList<>();
    }

    public String getId(){
        return id;
    }

    public void declare(String id){
        declarationId.add(id);
    }

    public boolean checkDeclaration(String _id){
        return (declarationId.contains(_id)) ? true : false;
    }
}

