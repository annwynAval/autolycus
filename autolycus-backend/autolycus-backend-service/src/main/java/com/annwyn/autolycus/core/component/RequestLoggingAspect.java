package com.annwyn.autolycus.core.component;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(99999)
public class RequestLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);

    @Pointcut("execution(public * com.annwyn.autolycus.core.controller..*.*(..))")
    public void requestLogging() {
    }

    @Around("requestLogging()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(this.logger.isDebugEnabled() || requestAttributes == null) {
            return joinPoint.proceed();
        }

        long currentTimeMillis = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        this.logger.debug("当前请求: {}, 执行花费{}ms.", requestAttributes.getRequest().getRequestURI(), System.currentTimeMillis() - currentTimeMillis);
        return object;
    }

}
