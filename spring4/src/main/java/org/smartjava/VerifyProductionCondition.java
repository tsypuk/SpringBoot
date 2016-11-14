package org.smartjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class VerifyProductionCondition implements Condition {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyProductionCondition.class);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        LOGGER.info("Bean annotation is present {}", Boolean.toString(metadata.isAnnotated(Bean.class.getName())));
        Environment environment = context.getEnvironment();
        return environment.containsProperty("prod");
    }
}
