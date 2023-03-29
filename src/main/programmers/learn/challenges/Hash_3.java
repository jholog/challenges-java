package main.programmers.learn.challenges;

import java.util.HashMap;
import java.util.Map;

public class Hash_3 {
    public int solution(String[][] clothes) {
        int answer = 1;

        // counting
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < clothes.length; i++)
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        // clac
        for (String cloth : map.keySet())
            answer *= map.get(cloth) + 1;

        return answer - 1;
    }


    public static void main(String[] args) {
        String[][] c = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        Hash_3 h = new Hash_3();
        System.out.println(h.solution(c));
    }
}
