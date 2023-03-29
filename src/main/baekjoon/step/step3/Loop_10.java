package main.baekjoon.step.step3;

import java.util.Scanner;

public class Loop_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = "*".repeat(i);   // Java 11 or greater is required.
            System.out.println(String.format("%" + n + "s", s));
        }
    }
}
