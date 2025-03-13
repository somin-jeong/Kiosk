package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<MenuItem> cartItems = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        cartItems.add(menuItem);
    }

    public void clearOrders() {
        cartItems.clear();
    }

    public boolean cartIsEmpty() {
        return cartItems.isEmpty();
    }

    public void orderSuccess() {
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", getTotalPrice());
        clearOrders();  // 장바구니 초기화
    }

    public void printOrderInfo() {
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        printOrders();
        System.out.println();
        printTotalPrice();
        System.out.println();
    }

    private void printOrders() {
        System.out.println("[ Orders ]");
        for (MenuItem menuItem : cartItems) {
            System.out.println(menuItem.toString());
        }
    }

    private void printTotalPrice() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n", getTotalPrice());
    }

    private double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem menuItem : cartItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }
}
