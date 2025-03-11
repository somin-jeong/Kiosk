package org.example;

import java.util.*;

public class Kiosk {
    // Scanner 선언
    private static final Scanner sc = new Scanner(System.in);

    // List 선언 및 초기화
    private final List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        int categoryNum = -1;
        while (categoryNum != 0) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            printCategoryMenus();

            try {
                // 카테고리 메뉴 숫자 입력 받기
                categoryNum = sc.nextInt();
                if (categoryNum > 0) {
                    // 입력 받은 숫자가 올바르다면 인덱스를 활용하여 Menu에 접근하기
                    Menu menu = menus.get(categoryNum - 1);

                    int menuNum = -1;
                    while (menuNum != 0) {
                        // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                        menu.printMenuItems();

                        try {
                            // 메뉴 숫자 입력 받기
                            menuNum = sc.nextInt();
                            if (menuNum > 0) {
                                menu.printSelectedMenu(menuNum);
                                break;
                            } else if (menuNum < 0) {
                                System.out.println("올바르지 않은 번호입니다.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                            sc.nextLine(); // 입력 버퍼 비우기
                        }
                    }
                } else if (categoryNum < 0) {
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

    private void printCategoryMenus() {
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        for (int i=0; i<menus.size(); i++) {
            System.out.println((i+1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료      | 종료");
    }
}
