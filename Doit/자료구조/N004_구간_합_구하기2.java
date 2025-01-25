package Doit.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N004_구간_합_구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        int[][] S = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int number = Integer.parseInt(st.nextToken());
                // 합 배열 초기화 : S[i][j] =  S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j]
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + number;
            }
        }
        for (int i = 0; i < query; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 구간 합 -> S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1]
            System.out.println(S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1]);
        }
    }
}
