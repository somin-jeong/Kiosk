package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public void orderSuccess(double discount) {
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", getTotalPrice()-(getTotalPrice()*discount));
        clearOrders();  // 장바구니 초기화
    }

    public void printOrderInfo() {
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        printOrders();
        System.out.println();
        printTotalPrice();
        System.out.println();
    }

    public void removeMenuItem(String menuName) {
        cartItems = cartItems.stream()
                .filter(menuItem -> !Objects.equals(menuItem.getMenuName(), menuName))
                .collect(Collectors.toList());
    }

    private void printOrders() {
        System.out.println("[ Orders ]");
        cartItems.stream().map(MenuItem::toString)
                .forEach(System.out::println);
    }

    private void printTotalPrice() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n", getTotalPrice());
    }

    private double getTotalPrice() {
        return cartItems.stream().mapToDouble(MenuItem::getPrice).sum();
    }
}
