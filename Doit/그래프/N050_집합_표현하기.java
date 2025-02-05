package Doit.그래프;

import java.util.Scanner;

public class N050_집합_표현하기 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        // 본인의 대표 노드는 본인으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int calc = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // union 연산 진행
            if (calc == 0) {
                union(a, b);
            } else {
                // a와 b가 같은 집합일 때 (대표 노드가 같을 때)
                if (checkSame(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    // 제일 중요한 부분 (재귀 함수 사용)
    private static int find(int a) {
        // 본인이 집합의 대표 노드인 경우
        if (a == parent[a]) {
            return a;
        } else {    // 본인이 집합의 대표 노드가 아닐 경우
            // 거쳐가는 노드 값을 루트 노드로 변경
            return parent[a] = find(parent[a]);
        }
    }

    // 두 원소가 같은 집합인지 확인
    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
    }
}
