package main.baekjoon.step.step6;

import java.util.*;

public class Advanced_2 {
    public static void main(String[] args) {
        Integer[] chess = {1, 1, 2, 2, 2, 8};

        Scanner scanner = new Scanner(System.in);
        Integer[] input = Arrays.asList(scanner.nextLine().split(" "))
                .stream()
                .map(s -> Integer.parseInt(s))
                .toArray(Integer[]::new);

        for (int i = 0; i < chess.length; i++) {
            System.out.print(chess[i] - input[i] + " ");
        }
    }
}
