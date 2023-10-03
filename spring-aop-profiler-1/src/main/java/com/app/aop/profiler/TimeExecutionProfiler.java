package com.app.aop.profiler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.app.aop.api.AOPController;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class TimeExecutionProfiler {
	
	Logger logger = LoggerFactory.getLogger(AOPController.class);

	@Around("execution(* com.app.*..*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object output = pjp.proceed();
        long elapsedTime = System.nanoTime() - start;

//        if (elapsedTime > 5) {
//            log.info("SLOW ALERT Method execution time : " + elapsedTime + " ns. Method: " + pjp.getSignature().toShortString());
//            log.info("JVM memory in use = {}", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            logger.info("LoggerSLOW ALERT Method execution time : " + elapsedTime + " ns. Method: " + pjp.getSignature().toShortString());
            logger.info("LoggerJVM memory in use = {}", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
//        }

        return output;
    }
}
