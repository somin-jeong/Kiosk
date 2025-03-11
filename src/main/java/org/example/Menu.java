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

    public String getCategory() {
        return category;
    }
}
