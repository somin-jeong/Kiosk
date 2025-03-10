package org.example;

public class MenuItem {
    private String menuName;
    private double price;
    private String description;

    public MenuItem(String menuName, double price, String description) {
        this.menuName = menuName;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-15s | W %.1f | %s", menuName, price, description);
    }

    public void printSelectedMenu() {
        System.out.println("선택한 메뉴 : " + menuName + ", " + price + ", " + description);
    }
}
