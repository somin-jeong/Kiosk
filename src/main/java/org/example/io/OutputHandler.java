package org.example.io;

import org.example.domain.Menu;
import org.example.domain.MenuItem;
import org.example.domain.UserType;

import java.util.Arrays;
import java.util.List;

public class OutputHandler {
    public static void printCategoryMenus(List<Menu> menus) {
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        menus.stream()
                .map(menu -> (menus.indexOf(menu) + 1) + ". " + menu.getCategory())
                .forEach(System.out::println);
        System.out.println("0. 종료      | 종료");
    }

    public static void printOrderMenu() {
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
    }

    public static void printAddCart(MenuItem menuItem) {
        menuItem.printSelectedMenu();
        System.out.println();
        System.out.println("\"" + menuItem + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public static void printStartOrder() {
        System.out.println("1. 주문      2. 메뉴 빼기      3. 메뉴판");
    }

    public static void printDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요.");
        Arrays.stream(UserType.values())
                .map(userType -> String.format("%d. %-10s : %2.0f%%",
                        userType.ordinal() + 1, userType.getUserType(), userType.getDiscountRate() * 100))
                .forEach(System.out::println);
        System.out.println("0. 뒤로가기");
    }

    public static void printRemoveMenuName() {
        System.out.println("장바구니에서 제외할 메뉴 이름을 입력해주세요.");
    }
}
