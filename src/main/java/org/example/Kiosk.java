package org.example;

import java.util.*;

public class Kiosk {
    // List 선언 및 초기화
    private final List<Menu> menus;
    private final Orders orders;

    public Kiosk(List<Menu> menus, Orders orders) {
        this.menus = menus;
        this.orders = orders;
    }

    public void start() {
        int categoryNum = -1;
        while (categoryNum != 0) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            printCategoryMenus();

            if (!orders.isEmpty()) {
                printOrderMenu();
            }

            // 카테고리 메뉴 숫자 입력 받기
            categoryNum = InputHandler.getIntInput();

            if (categoryNum > 0 && categoryNum <= menus.size()) {
                // 입력 받은 숫자가 올바르다면 인덱스를 활용하여 Menu에 접근하기
                Menu menu = menus.get(categoryNum - 1);

                int menuNum = -1;
                while (menuNum != 0) {
                    // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                    menu.printMenuItems();

                    // 메뉴 숫자 입력 받기
                    menuNum = InputHandler.getIntInput();

                    if (menuNum > 0 && menuNum <= menu.getMenuItemSize()) {
                        menu.printSelectedMenu(menuNum);
                        if (menu.addOrder(menuNum, orders)) {
                            break;
                        }
                    } else if (menuNum != 0) {
                        System.out.println("올바르지 않은 번호입니다.");
                    }
                }
            } else if (!orders.isEmpty() && categoryNum == menus.size() + 1) {
                orders.order();
            } else if (!orders.isEmpty() && categoryNum == menus.size() + 2) {
                orders.clearOrders();
            } else if (categoryNum != 0) {
                System.out.println("올바르지 않은 번호입니다.");
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

    private void printOrderMenu() {
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
    }
}
