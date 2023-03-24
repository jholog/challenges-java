package programmers.skillchecks;

import java.util.Arrays;

public class Level1 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        // check arr length, 행과 열의 크기는 같다고 가정
        answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};

        Level1 l = new Level1();
        int[][] answer = l.solution(arr1, arr2);
        System.out.println(Arrays.deepToString(answer));
    }
}
