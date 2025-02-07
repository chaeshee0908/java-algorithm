package Doit.조합;

import java.util.Scanner;

public class N077_이항계수_구하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] D = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i-1][j-1] + D[i-1][j];
                D[i][j] = D[i][j] % 10007;  // 오버플로우 방지
            }
        }
        System.out.println(D[N][K]);
    }
}
