package main.baekjoon.step.step3;

import java.util.Arrays;
import java.util.Scanner;

public class Loop_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            int val = Arrays.stream(Arrays.stream(line).mapToInt(Integer::parseInt).toArray()).sum();
            System.out.println("Case #" + (i + 1) + ": " + val);
        }
    }
}
