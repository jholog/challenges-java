package programmers.learn.challenges;

import java.util.Arrays;

public class Sort_1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] list = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(list);
            answer[i] = list[commands[i][2]-1];
        }

        return answer;
    }

//    public int[] solution(int[] array, int[][] commands) {
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < commands.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = commands[i][0]; j <= commands[i][1]; j++)
//                list.add(array[j-1]);
//            Collections.sort(list);
//            int n = list.get(commands[i][2]-1);
//            result.add(n);
//        }
//
//        int[] answer = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
//
//        return answer;
//    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Sort_1 s = new Sort_1();
        s.solution(array, commands);
    }
}
