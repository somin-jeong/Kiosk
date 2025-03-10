package org.example;

import java.util.*;

public class Kiosk {
    // Scanner 선언
    private static final Scanner sc = new Scanner(System.in);

    // List 선언 및 초기화
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        System.out.println("[ SHAKESHACK MENU ]");

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        for (int i=0; i<menuItems.size(); i++) {
            System.out.print((i+1) + ". ");
            System.out.println(menuItems.get(i).toString());
        }
        System.out.println("0. 종료      | 종료");

        // 숫자를 입력 받기
        int num = -1;
        while (num != 0) {
            try {
                num = sc.nextInt();
                if (num > 0) {
                    // 숫자에 따라 다른 로직 실행
                    MenuItem menuItem = menuItems.get(num-1);
                    menuItem.printSelectedMenu();
                    break;
                } else if (num < 0) {
                    System.out.println("올바르지 않은 번호입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine(); // 입력 버퍼 비우기
            }
        }

        // 프로그램을 종료
        System.out.println("프로그램을 종료합니다.");
    }
}
