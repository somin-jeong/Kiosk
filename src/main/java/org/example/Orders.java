package org.example;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    List<MenuItem> orders = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        orders.add(menuItem);
    }


}
