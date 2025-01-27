package Doit.탐색.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N026_DFS와_BFS_프로그램 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        A = new ArrayList[N+1];
        // A 초기화
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        // 관계 설정
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            A[v1].add(v2);
            A[v2].add(v1);
        }
        // 작은 노드부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        sb = new StringBuilder();
        visited = new boolean[N+1];
        dfs(start);
        System.out.println(sb);
        sb = new StringBuilder();
        visited = new boolean[N+1];
        bfs(start);
        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int next : A[v]) {
            if (!visited[next])
                dfs(next);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            visited[now] = true;
            for (int next : A[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
