package main.baekjoon.step.step4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array1d_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine().split(" ")[1]);
        Stream<String> a = Arrays.stream(sc.nextLine().split(" "))
                .filter(e -> Integer.parseInt(e) < x);
        System.out.println(a.collect(Collectors.joining(" ")));
    }
}
