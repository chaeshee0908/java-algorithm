package Doit.자료구조.스택과큐;

import java.util.Scanner;
import java.util.Stack;

public class N012_오큰수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int index = stack.pop();
                result[index] = A[i];
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            if (value == 0) {
                sb.append("-1 ");
            } else {
                sb.append(value).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
