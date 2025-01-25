package Doit.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N025_친구_관계_파악하기 {
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;
        // ArrayList 초기화
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }
        // 관계 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            friends[v1].add(v2);
            friends[v2].add(v1);
        }
        // 탐색
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrive)
                break;
        }
        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static void dfs(int v, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[v] = true;
        for(int i : friends[v]) {
            if (!visited[i])
                dfs(i, depth+1);
        }
        visited[v] = false;
    }
}
