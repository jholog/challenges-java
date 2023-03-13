package programmers.learn.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash_2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        if (phone_book.length <= 0 || phone_book.length > 1000000) return answer;
        Arrays.sort(phone_book);
        Map<String, Integer> map = new HashMap<>();
        for (String number : phone_book) {
            for (int i = 0; i < number.length(); i++)
                if (map.containsKey(number.substring(0, i+1))) return false;
            map.put(number, 0);
        }

        return answer;

//        for(int i=0; i<phoneBook.length-1; i++) {
//            for(int j=i+1; j<phoneBook.length; j++) {
//                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
//                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
//            }
//        }
//        return true;
    }

    public static void main(String[] args) {
        String[] p = new String[]{"119", "97674223", "1195524421"};
        p = new String[]{"123", "456", "789"};
        p = new String[]{"12","123","1235","567","88"};
        p = new String[]{"1195524421", "97674223", "119"};
        Hash_2 h = new Hash_2();
        System.out.println(h.solution(p));
    }
}
