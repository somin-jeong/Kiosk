package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<MenuItem> cartItems = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        cartItems.add(menuItem);
    }

    // 주문 완료했으면 true, 취소했으면 false
    public void order() {
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        printOrders();
        System.out.println();
        printTotalPrice();

        int num = 0;
        while (num != 2) {
            System.out.println();
            System.out.println("1. 주문      2. 메뉴판");

            num = InputHandler.getIntInput();

            if (num == 1) {
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", getTotalPrice());
                System.out.println();

                // 장바구니 초기화
                clearOrders();

                break;
            } else if (num != 2) {
                System.out.println("올바르지 않은 번호입니다.");
            }
        }
    }

    public void clearOrders() {
        cartItems.clear();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void printOrders() {
        System.out.println("[ Orders ]");
        for (MenuItem menuItem : cartItems) {
            System.out.println(menuItem.toString());
        }
    }

    public void printTotalPrice() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f%n", getTotalPrice());
    }

    private double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem menuItem : cartItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }

}
