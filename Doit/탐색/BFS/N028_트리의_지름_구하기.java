package Doit.탐색.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N028_트리의_지름_구하기 {
    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        // 트리 정보 입력받기
        for (int i = 0; i < N; i++) {
            int node = sc.nextInt();
            while (true) {
                int v = sc.nextInt();
                if (v == -1)
                    break;
                int dist = sc.nextInt();
                tree[node].add(new Edge(v, dist));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        // 임의의 노드에서 각 노드까지의 거리 구하기 -> O(n)
        bfs(1);
        int startIndex = 1;
        // 임의의 노드에서 가장 먼 노드로부터 최장 거리 찾기
        for (int i = 0; i <= N; i++) {
            if (distance[startIndex] < distance[i]) {
                startIndex = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        bfs(startIndex);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);    // 시작 vertex, dist(시작 지점으로부터의 거리)
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge E : tree[now]) {
                if (!visited[E.v]) {
                    queue.add(E.v);
                    visited[E.v] = true;
                    // 트리의 특성상 하나의 노드에서 다른 노드로 가는 거리는 유일하기 때문에 거리를 비교하여 초기화해줄 필요가 없다!!
                    distance[E.v] = distance[now] + E.dist;
                }
            }
        }
    }

    static class Edge {
        int v;
        int dist;
        public Edge(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}
