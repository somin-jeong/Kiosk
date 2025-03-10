package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Scanner 선언
    private static final Scanner sc = new Scanner(System.in);

    // List 선언 및 초기화
    private static final List<MenuItem> menuItems = new ArrayList<>();
    public static void main(String[] args) {
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        System.out.println("[ SHAKESHACK MENU ]");

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        for (int i=0; i<menuItems.size(); i++) {
            System.out.print((i+1) + ". ");
            System.out.println(menuItems.get(i).toString());
        }
        System.out.println("0. 종료      | 종료");

        // 숫자를 입력 받기
        int num = sc.nextInt();
        while (num != 0) {
            if (num > 0) {
                // 숫자에 따라 다른 로직 실행
                switch (num) {
                    case 1 -> {
                        MenuItem menuItem = menuItems.get(0);
                        menuItem.printSelectedMenu();
                    }
                    case 2 -> {
                        MenuItem menuItem = menuItems.get(1);
                        menuItem.printSelectedMenu();
                    }
                    case 3 -> {
                        MenuItem menuItem = menuItems.get(2);
                        menuItem.printSelectedMenu();
                    }
                    case 4 -> {
                        MenuItem menuItem = menuItems.get(3);
                        menuItem.printSelectedMenu();
                    }
                }
                break;
            }
            System.out.println("올바르지 않은 번호입니다.");
            num = sc.nextInt();
        }

        // 프로그램을 종료
        System.out.println("프로그램을 종료합니다.");
    }
}