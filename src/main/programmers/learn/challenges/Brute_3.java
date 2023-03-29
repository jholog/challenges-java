package main.programmers.learn.challenges;

public class Brute_3 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = i + 2;
                int y = (yellow / i) + 2;
                int z = x * y;
                if (z == size && x >= y) {
                    System.out.println(x + " x " + y);
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Brute_3 b = new Brute_3();
//        System.out.println(b.solution(10, 2));
//        System.out.println(b.solution(8, 1));
//        System.out.println(b.solution(24, 24));
        System.out.println(b.solution(10, 1));
    }
}
