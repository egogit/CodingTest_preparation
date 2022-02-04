import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        LinkedList<String> words = new LinkedList<>();
        for(String s : strings){
            words.add(s);
        }
        Collections.sort(words, (s1, s2) -> {
            char alpha1 = s1.charAt(n);
            char alpha2 = s2.charAt(n);
            if (alpha1 == alpha2) {
                return s1.compareTo(s2);
            } else {
                return alpha1 - alpha2;
            }
        });
        answer = words.toArray(new String[strings.length]);
        
        return answer;
    }
}

