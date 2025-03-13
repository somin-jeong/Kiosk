package org.example;

import java.util.*;

public class Kiosk {
    // List 선언 및 초기화
    private final List<Menu> menus;
    private final Order order;

    public Kiosk(List<Menu> menus, Order order) {
        this.menus = menus;
        this.order = order;
    }

    public void start() {
        orderMenu();

        // 프로그램을 종료
        System.out.println("프로그램을 종료합니다.");
    }

    private void orderMenu() {
        int categoryNum = -1;
        while (categoryNum != 0) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            OutputHandler.printCategoryMenus(menus);

            if (!order.isEmpty()) {
                OutputHandler.printOrderMenu();
            }

            // 카테고리 메뉴 숫자 입력 받기
            categoryNum = InputHandler.getIntInput();
            navigateCategory(categoryNum);
        }
    }

    private void navigateCategory(int categoryNum) {
        if (categoryNum > 0 && categoryNum <= menus.size()) {
            // 입력 받은 숫자가 올바르다면 인덱스를 활용하여 Menu에 접근하기
            Menu menu = menus.get(categoryNum - 1);
            selectMenuItem(menu);
        } else if (!order.isEmpty() && categoryNum == menus.size() + 1) {
            order.order();
        } else if (!order.isEmpty() && categoryNum == menus.size() + 2) {
            order.clearOrders();
        } else if (categoryNum != 0) {
            System.out.println("올바르지 않은 번호입니다.");
        }
    }

    private void selectMenuItem(Menu menu) {
        int menuNum = -1;
        while (menuNum != 0) {
            // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
            menu.printMenuItems();

            // 메뉴 숫자 입력 받기
            menuNum = InputHandler.getIntInput();

            // 장바구니에 추가 완료하면 반복문을 빠져나온다.
            if (navigateMenuItem(menu, menuNum)) break;
        }
    }

    private boolean navigateMenuItem(Menu menu, int menuNum) {
        if (menuNum > 0 && menuNum <= menu.getMenuItemSize()) {
            menu.printSelectedMenu(menuNum);
            return menu.addOrder(menuNum, order);
        } else if (menuNum != 0) {
            System.out.println("올바르지 않은 번호입니다.");
        }
        return false;
    }
}
