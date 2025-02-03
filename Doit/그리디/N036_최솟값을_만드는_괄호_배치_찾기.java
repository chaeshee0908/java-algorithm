package Doit.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N036_최솟값을_만드는_괄호_배치_찾기 {
    static boolean canMinus;
    static StringBuilder number;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
        char[] C = formula.toCharArray();
        number = new StringBuilder();
        for (char c : C) {
            if (c == '+' || c == '-') {
                calculate();
                // 처음 나온 '-' 기호 이후로는 모두 뺄 수 있음
                if (c == '-') {
                    canMinus = true;
                }
                number = new StringBuilder();
                continue;
            }
            // 0으로 시작하는 숫자가 들어올 경우 0은 무시
            if (number.length() == 0 && c == '0')
                continue;
            number.append(c);
        }
        calculate();
        System.out.println(answer);
    }

    private static void calculate() {
        if (number.length() == 0) {
            number.append('0');
        }
        if (canMinus) {
            answer -= Integer.parseInt(number.toString());
        } else {
            answer += Integer.parseInt(number.toString());
        }
    }
}
