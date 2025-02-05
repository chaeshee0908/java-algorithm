package Doit.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N051_여행_계획_짜기 {
    static int N;
    static int[] parent;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        // 본인이 본인의 대표 노드
        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (s[j].equals("1"))
                    union(i, j);
            }
        }
        String[] planStr = br.readLine().split(" ");
        plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(planStr[i])-1;
        }
        // 여행 계획 도시들이 1개의 대표 도시로 연결돼있는지 확인
        int mainCity = find(plan[0]);
        for (int i = 1; i < M; i++) {
            if (mainCity != find(plan[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int n) {
        if (n == parent[n])
            return n;
        else
            return parent[n] = find(parent[n]);
    }
}
