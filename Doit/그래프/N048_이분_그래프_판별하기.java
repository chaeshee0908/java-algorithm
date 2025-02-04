package Doit.그래프;

import java.util.ArrayList;
import java.util.Scanner;

public class N048_이분_그래프_판별하기 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int a = 0; a < K; a++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            graph = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            isEven = true;
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            // graph 초기화
            for (int i = 0; i < E; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                graph[start].add(end);
                graph[end].add(start);
            }
            for (int v = 1; v <= V; v++) {
                if (isEven)
                    dfs(v);
                else
                    break;
            }
            if (isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int next : graph[v]) {
            if (!visited[next]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리
                check[next] = (check[v] + 1) % 2;
                dfs(next);
            }
            // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
            else if (check[v] == check[next]) {
                isEven = false;
            }
        }
    }
}
