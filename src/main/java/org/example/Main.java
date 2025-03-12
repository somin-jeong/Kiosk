package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        List<MenuItem> burgerItems = new ArrayList<>();
        burgerItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Menu burgers = new Menu("Burgers", burgerItems);

        List<MenuItem> drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem("Coca-Cola", 2.5, "톡 쏘는 시원한 코카콜라"));
        drinkItems.add(new MenuItem("Lemonade", 3.0, "상큼한 천연 레몬에이드"));
        drinkItems.add(new MenuItem("Root Beer", 3.5, "부드럽고 달콤한 루트비어"));
        Menu drinks = new Menu("Drinks", drinkItems);

        List<MenuItem> dessertItems = new ArrayList<>();
        dessertItems.add(new MenuItem("Vanilla Custard", 4.0, "진한 바닐라 커스터드 아이스크림"));
        dessertItems.add(new MenuItem("Chocolate Brownie", 5.0, "달콤하고 촉촉한 초콜릿 브라우니"));
        dessertItems.add(new MenuItem("Strawberry Sundae", 4.5, "딸기 소스가 올라간 바닐라 아이스크림"));
        dessertItems.add(new MenuItem("Cheesecake", 5.5, "부드러운 뉴욕 스타일 치즈케이크"));
        Menu desserts = new Menu("Desserts", dessertItems);

        List<Menu> menus = List.of(burgers, drinks, desserts);
        Kiosk kiosk = new Kiosk(menus, new Orders());
        kiosk.start();
    }
}