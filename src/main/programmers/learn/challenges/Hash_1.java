package main.programmers.learn.challenges;

import java.util.HashMap;
import java.util.Map;

public class Hash_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        if (participant.length <= 0 || participant.length > 100000) return answer;

        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) map.put(name, map.getOrDefault(name, 0) + 1);
        for (String name : completion) map.put(name, map.get(name) -1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) answer = entry.getKey();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] p = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] c = new String[]{"stanko", "ana", "mislav"};
        Hash_1 h = new Hash_1();
        String s = h.solution(p, c);
        System.out.println(s);
    }
}
