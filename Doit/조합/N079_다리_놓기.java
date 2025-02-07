package Doit.조합;

import java.util.Scanner;

public class N079_다리_놓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int query = sc.nextInt();
        int[][] D = new int[30][30];
        for (int i = 0; i < 30; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }
        for (int i = 0; i < query; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(D[M][N]);
        }
    }
}
