package main.programmers.learn.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack_1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();
        // 처음 작업이 top에 위치할 수 있도록 역순으로 push
        for (int i = progresses.length - 1; i >= 0; i--) {
            int day = (100 - progresses[i]) / speeds[i];
            int rest = ((100 - progresses[i]) % speeds[i] > 0) ? 1 : 0;
            stack.push(day + rest);
        }
        // 현재 작업의 총 작업일이 다음 작업일 보다 크면, 다음 작업은 이미 완료된 상태이다.
        List<Integer> tmp = new ArrayList<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
                cnt++;
            }
            tmp.add(cnt);
        }
        answer = new int[tmp.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = tmp.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Stack_1 s = new Stack_1();
        System.out.println(s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}
