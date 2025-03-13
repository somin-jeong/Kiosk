package org.example;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    List<MenuItem> orders = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        orders.add(menuItem);
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
        orders.clear();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public void printOrders() {
        System.out.println("[ Orders ]");
        for (MenuItem order : orders) {
            System.out.println(order.toString());
        }
    }

    public void printTotalPrice() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f%n", getTotalPrice());
    }

    private double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem order : orders) {
            totalPrice += order.getPrice();
        }
        return totalPrice;
    }

}
