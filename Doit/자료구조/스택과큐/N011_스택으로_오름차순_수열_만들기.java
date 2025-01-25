package Doit.자료구조.스택과큐;

import java.util.Scanner;
import java.util.Stack;

public class N011_스택으로_오름차순_수열_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] goal = new int[N];
        for (int i = 0; i < N; i++) {
            goal[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int now = 1;    // 오름차순 숫자
        boolean result = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now_goal = goal[i];
            if (now_goal >= now) {
                while (now_goal >= now) {   // push
                    stack.push(now++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {    // 현재 수열 값 < 오름차순 자연수: pop()을 수행해 원소를 꺼냄
                int n = stack.pop();
                // 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
                if (n > now_goal) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) System.out.println(sb.toString());
    }
}
