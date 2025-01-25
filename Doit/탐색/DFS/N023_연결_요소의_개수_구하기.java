package Doit.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N023_연결_요소의_개수_구하기 {
    static ArrayList<Integer>[] A;  // 2차원
    static boolean visited[];   // 방문 기록 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            // 양방향
            A[v1].add(v2);
            A[v2].add(v1);
        }
        int count = 0;  // 연결 요소 개수
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (visited[i] == false) {  // 연결 노드 중 방문하지 않았던 노드만 탐색
                dfs(i);
            }
        }
    }
}
