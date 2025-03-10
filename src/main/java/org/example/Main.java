package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("[ SHAKESHACK MENU ]");

        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n"+
                "0. 종료      | 종료");

        int num = sc.nextInt();
        while (num != 0) {
            if (num > 0) {
                // 숫자에 따라 다른 로직 실행
                switch (num) {
                    case 1 -> System.out.println("1을 선택했습니다.");
                    case 2 -> System.out.println("2을 선택했습니다.");
                    case 3 -> System.out.println("3을 선택했습니다.");
                    case 4 -> System.out.println("4을 선택했습니다.");
                }
                break;
            }
            System.out.println("올바르지 않은 번호입니다.");
            num = sc.nextInt();
        }
        System.out.println("프로그램을 종료합니다.");
    }
}