package org.smartjava.advices;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {

    @Before("execution(** org.smartjava.beans.Performance.perform(..))")
    public void silenceCellPhones() {
        System.err.println("ASPECT");
    }
}
