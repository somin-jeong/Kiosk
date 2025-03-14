package org.example.domain;

import java.util.List;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public MenuItem getMenuItem(int selectedNum) {
        return menuItems.get(selectedNum-1);
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItems() {
        System.out.println();
        System.out.println("[ " + category + " MENU ]");
        menuItems.stream()
                .map(item -> (menuItems.indexOf(item) + 1) + ". " + item.toString())
                .forEach(System.out::println);
        System.out.println("0. 뒤로가기");
    }

    public int getMenuItemSize() {
        return menuItems.size();
    }

    public String getCategory() {
        return category;
    }
}
