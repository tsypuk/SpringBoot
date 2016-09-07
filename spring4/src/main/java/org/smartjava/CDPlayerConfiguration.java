package org.smartjava;

import org.smartjava.beans.CompactDisc;
import org.smartjava.beans.SgPeppersCD;
import org.smartjava.beans.ShopingCart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("org.smartjava.beans")
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