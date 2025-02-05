package Doit.그래프;

import java.util.Scanner;

public class N61_가장_빠른_버스_노선_구하기 {
    static final int INF = 10000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] floyd = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j)
                    continue;
                floyd[i][j] = INF;
            }
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (floyd[a][b] > c) floyd[a][b] = c;
        }
        // 플로이드 워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (floyd[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(floyd[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
