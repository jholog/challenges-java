package main.baekjoon.step.step5;

import java.util.Scanner;

public class String_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s.charAt(sc.nextInt() - 1));
    }
}
