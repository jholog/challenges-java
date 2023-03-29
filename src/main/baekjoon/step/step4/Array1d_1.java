package main.baekjoon.step.step4;

import java.util.Arrays;
import java.util.Scanner;

public class Array1d_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = Integer.parseInt(sc.nextLine());
        if (arr.length == n) {
            System.out.println(Arrays.stream(arr)
                    .filter(x -> x == v)
                    .count());
        }
    }
}
