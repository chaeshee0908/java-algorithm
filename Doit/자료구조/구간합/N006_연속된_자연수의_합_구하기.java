package Doit.자료구조.구간합;

import java.util.Scanner;

public class N006_연속된_자연수의_합_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 합 배열
        int[] S = new int [N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + i;
        }
        int start = 0;
        int end = 1;
        int count = 0;
        while (end <= N) {
            // 시작 지점보다 끝점이 더 크면 안됨
            if (start > end) {
                end++;
            }
            int prefixSum = S[end] - S[start];
            // 구간합이 N과 같을 경우
            if (prefixSum == N) {
                count++;
                end++;
            }
            // 구간합이 N보다 작을 경우
            else if (prefixSum < N) {
                end++;
            }
            // 구간합이 N보다 클 경우
            else {
                start++;
            }
        }
        System.out.println(count);
    }
}
