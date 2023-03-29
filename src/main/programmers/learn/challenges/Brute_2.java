package main.programmers.learn.challenges;

import java.util.ArrayList;

public class Brute_2 {
    private int answer = 0;
    private ArrayList<Integer> checked = new ArrayList<>();
    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        boolean[] visited = new boolean[chars.length];
        for (int i = 1; i <= chars.length; i++) {
//            combination(chars, visited, 0, i);
            permutation(chars, 0, i);
        }
        return answer;
    }

    private void permutation(char[] chars, int depth, int r) {
        if (depth == r) {
            getNumber(chars, r);
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            swap(chars, depth, i);
            permutation(chars, depth + 1, r);
            swap(chars, depth, i);
        }
    }

    private void swap(char[] chars, int depth, int i) {
        char temp = chars[depth];
        chars[depth] = chars[i];
        chars[i] = temp;
    }

    private void getNumber(char[] chars, int r) {
        String str = "";
        for (int i = 0; i < r; i++) {
            str += chars[i];
        }
        if (isPrime(str)) answer ++;
    }

    private void combination(char[] chars, boolean[] visited, int depth, int r) {
        if (r == 0) {
            getNumber(chars, visited);
            return;
        }
        if (depth == chars.length) return;
        else {
            visited[depth] = true;
            combination(chars, visited, depth + 1, r - 1);
            visited[depth] = false;
            combination(chars, visited, depth + 1, r);
        }
    }

    private void getNumber(char[] chars, boolean[] visited) {
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) str += chars[i];
        }
        if (isPrime(str)) answer++;
    }

    private boolean isPrime(String str) {
        int n = Integer.parseInt(str);
        if (checked.contains(n)) return false;
        checked.add(n);
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        System.out.println("result : " + n);
        return n >= 2;
    }

    public static void main(String[] args) {
//        String numbers = "011";
//        String numbers = "17";
        String numbers = "01010";
        Brute_2 b = new Brute_2();
        System.out.println(b.solution(numbers));
    }
}
