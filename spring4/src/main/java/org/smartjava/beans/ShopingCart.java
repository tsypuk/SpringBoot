package org.smartjava.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShopingCart {
    String userName;
    int moneyLimit;

    public ShopingCart(@Value("${cd.artist}") String userName) {
        this.userName = userName;
    }

    public void setMoneyLimit(int moneyLimit) {
        this.moneyLimit = moneyLimit;
    }
}
