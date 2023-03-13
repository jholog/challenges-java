package programmers.skillchecks;

public class Level1_345109 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        // check arr length, 행과 열의 크기가 같다고 가정
        if (arr1.length > 500 || arr1[0].length > 500) return answer;

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

        Level1_345109 l = new Level1_345109();
        int[][] answer = l.solution(arr1, arr2);
        System.out.println(answer);
    }
}
