package main.baekjoon.step.step3;

import java.util.Scanner;

public class Loop_5 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 0; i < n/4; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
