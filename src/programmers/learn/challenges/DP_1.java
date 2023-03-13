package programmers.learn.challenges;

import java.util.HashSet;
import java.util.Set;

public class DP_1 {
    public int solution(int N, int number) {
        Set<Integer>[] set = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
            String n = new String(new char[i]).replace("\0", Integer.toString(N));
            set[i].add(Integer.parseInt(n));
        }

        for (int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for (int x : set[j]) {
                    for(int y : set[i-j]) {
                        set[i].add(x + y);
                        set[i].add(x - y);
                        set[i].add(x * y);
                        if(y!=0)
                            set[i].add(x / y);
                    }
                }
            }
            if (set[i].contains(number)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        DP_1 dp = new DP_1();
//        System.out.println(dp.solution(5, 12));
//        System.out.println(dp.solution(5, 5));
//        System.out.println(dp.solution(4, 31));
//        System.out.println(dp.solution(8, 5800));
        int x = 5%3;
        System.out.println(x);
    }
}
