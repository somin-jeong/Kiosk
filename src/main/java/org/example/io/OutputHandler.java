package org.example.io;

import org.example.domain.Menu;

import java.util.List;

public class OutputHandler {
    public static void printCategoryMenus(List<Menu> menus) {
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        for (int i=0; i<menus.size(); i++) {
            System.out.println((i+1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료      | 종료");
    }

    public static void printOrderMenu() {
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
    }
}
