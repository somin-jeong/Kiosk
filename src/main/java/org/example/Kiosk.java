package org.example;

import org.example.domain.Menu;
import org.example.domain.MenuItem;
import org.example.domain.Order;
import org.example.domain.UserType;
import org.example.io.InputHandler;
import org.example.io.OutputHandler;

import java.util.List;

public class Kiosk {
    // List 선언 및 초기화
    private final List<Menu> menus;
    private final Order order;

    public Kiosk(List<Menu> menus, Order order) {
        this.menus = menus;
        this.order = order;
    }

    public void start() {
        orderMenu();

        // 프로그램을 종료
        System.out.println("프로그램을 종료합니다.");
    }

    private void orderMenu() {
        int categoryNum;
        do {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            OutputHandler.printCategoryMenus(menus);

            if (!order.cartIsEmpty()) {
                OutputHandler.printOrderMenu();
            }

            // 카테고리 메뉴 숫자 입력 받기
            categoryNum = InputHandler.getIntInput();
            navigateCategory(categoryNum);
        } while (categoryNum != 0);
    }

    private void navigateCategory(int categoryNum) {
        if (categoryNum > 0 && categoryNum <= menus.size()) {
            // 입력 받은 숫자가 올바르다면 인덱스를 활용하여 Menu에 접근하기
            Menu menu = menus.get(categoryNum - 1);
            selectMenuItem(menu);
        } else if (!order.cartIsEmpty() && categoryNum == menus.size() + 1) {
            startOrder();
        } else if (!order.cartIsEmpty() && categoryNum == menus.size() + 2) {
            order.clearOrders();
        } else if (categoryNum != 0) {
            System.out.println("올바르지 않은 번호입니다.");
        }
    }

    private void selectMenuItem(Menu menu) {
        int menuNum;
        do {
            // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
            menu.printMenuItems();

            // 메뉴 숫자 입력 받기
            menuNum = InputHandler.getIntInput();

            // 장바구니에 추가 완료하면 반복문을 빠져나온다.
            if (navigateMenuItem(menu, menuNum)) break;
        } while (menuNum != 0);
    }

    private boolean navigateMenuItem(Menu menu, int menuNum) {
        if (menuNum > 0 && menuNum <= menu.getMenuItemSize()) {
            return addCart(menu, menuNum);
        } else if (menuNum != 0) {
            System.out.println("올바르지 않은 번호입니다.");
        }
        return false;
    }

    // 주문 완료했으면 true, 취소했으면 false
    public void startOrder() {
        order.printOrderInfo();
        int num;
        do {
            OutputHandler.printStartOrder();
            num = InputHandler.getIntInput();
            if (navigateOrder(num)) break;
        } while (num != 2);
    }

    private boolean navigateOrder(int num) {
        if (num == 1) {
            double discountRate = getDiscountRate();
            order.orderSuccess(discountRate);
            return true;
        } else if (num != 2) {
            System.out.println("올바르지 않은 번호입니다.");
        }
        return false;
    }

    // 장바구니에 추가 완료했으면 true, 취소하면 false 반환
    public boolean addCart(Menu menu, int selectedNum) {
        MenuItem menuItem = menu.getMenuItem(selectedNum);
        int num;
        do {
            OutputHandler.printAddCart(menuItem);
            num = InputHandler.getIntInput();
            if (navigateAddCart(num, menuItem)) return true;
        } while (num != 2);
        return false;
    }

    private boolean navigateAddCart(int num, MenuItem menuItem) {
        if (num == 1){
            menuItem.printOrderSuccess();
            order.addItem(menuItem);
            return true;
        } else if (num != 2) {
            System.out.println("올바르지 않은 번호입니다.");
        }
        return false;
    }

    private double getDiscountRate() {
        int num;
        do {
            OutputHandler.printDiscountInfo();
            num = InputHandler.getIntInput();
            for (UserType userType : UserType.values()) {
                if (userType.ordinal()+1 == num) {
                    return userType.getDiscountRate();
                }
            }
            if (num > UserType.values().length || num <= 0) {
                System.out.println("올바르지 않은 번호입니다.");
            }
        } while (num != 0);
        return 0;
    }
}
