package Doit.자료구조;

import java.util.Scanner;

public class N005_나머지_합_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[N];
        S[0] = sc.nextInt();
        // 햡 배열 초기화
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }
        long result = 0;
        // 합 배열의 모든 값에 % 연산 수행
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            // 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
            if (remainder == 0) result++;
            // 나머지가 같은 인덱스의 개수
            C[remainder]++;
        }
        for (int i = 0; i < N; i++) {
            // 나머지의 개수가 0개가 아닌 수
            if (C[i] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 (r=2일 경우 공식 n(n-1)/2)
                result = result + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }
}
