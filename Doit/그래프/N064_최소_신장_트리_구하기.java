package Doit.그래프;

import java.util.ArrayList;
import java.util.Scanner;

public class N064_최소_신장_트리_구하기 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<TEdge> edges = new ArrayList<>();
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new TEdge(s, e, w));
        }
        edges.sort(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        int answer = 0;
        for (TEdge edge : edges) {
            boolean canUnion = union(edge.start, edge.end);
            if (canUnion)
                answer += edge.weight;
        }
        System.out.println(answer);
    }

    private static boolean union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        if (v1 != v2) {
            parent[v2] = v1;
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        else {
            return parent[a] = find(parent[a]);
        }
    }
}

class TEdge {
    int start;
    int end;
    int weight;

    public TEdge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}