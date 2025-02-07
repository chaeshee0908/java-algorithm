package Doit.조합;

import java.util.Scanner;

public class N076_이항계수_구하기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] comb = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            comb[i][0] = 1; // n에서 0개를 뽑는 경우(=선택하지 않는 경우)의 수는 무조건 1가지
            comb[i][1] = i; // n에서 1개를 뽑는 경우는 무조건 n개
            comb[i][i] = 1; // 본인 개수만큼 뽑는 경우 무조건 1가지
        }
        comb[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
            }
        }
        System.out.println(comb[N][K]);
    }
}
