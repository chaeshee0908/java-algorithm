package Doit.자료구조.배열과리스트;

import java.util.Scanner;

public class N001_숫자의_합_구하기 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String sNum = sc.next();
       char[] cNum = sNum.toCharArray();
       int sum = 0;
       for (char c : cNum) {
           sum += c - '0';
       }
       System.out.println(sum);
    }
}
