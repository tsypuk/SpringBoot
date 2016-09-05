package com.example;

import com.example.bean.CompactDisc;
import com.example.bean.SgPeppersCD;
import com.example.bean.ShopingCart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.example.bean")
//@EnableAutoConfiguration
public class CDPlayerConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(CDPlayerConfiguration.class);
    @Autowired
    Environment environment;

    @Bean
    @Conditional(VerifyCondition.class)
    CompactDisc conditional() {
        return new SgPeppersCD();
    }

    @Bean
    ShopingCart shopingCart() {
        String user = environment.getProperty("cd.artist", "user");
        LOGGER.info("username is: {}", user);
        Integer moneyLimit = environment.getProperty("shoping.cart.money.limit=100", Integer.class, 0);

        ShopingCart shopingCart = new ShopingCart(user);
        shopingCart.setMoneyLimit(moneyLimit);

        return shopingCart;
    }

}