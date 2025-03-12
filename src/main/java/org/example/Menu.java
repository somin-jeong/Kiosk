package org.example;

import java.util.List;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItems() {
        System.out.println();
        System.out.println("[ " + category + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 뒤로가기");
    }

    public void printSelectedMenu(int selectedNum) {
        MenuItem menuItem = menuItems.get(selectedNum-1);
        menuItem.printSelectedMenu();
    }

    public int getMenuItemSize() {
        return menuItems.size();
    }

    public String getCategory() {
        return category;
    }

    // 장바구니에 추가 완료했으면 true, 취소하면 false 반환
    public boolean addOrder(int selectedNum, Orders orders) {
        int num = -1;
        while (num != 2) {
            System.out.println();
            MenuItem menuItem = menuItems.get(selectedNum-1);
            System.out.println("\"" + menuItem.toString() + "\"");

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            num = ExceptionHandler.handleInputMismatch();

            if (num == 1){
                menuItem.printOrderSuccess();
                orders.addItem(menuItem);
                return true;
            } else if (num != 2) {
                System.out.println("올바르지 않은 번호입니다.");
            }
        }
        return false;
    }
}
