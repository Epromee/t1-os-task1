package com.epromee.ost1.homework1;

import java.util.concurrent.CompletableFuture;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackTimeAspect {

    private TimeTrackerStatsOperator statsSender;

    public TrackTimeAspect(
        @Autowired TimeTrackerStatsOperator statsSender
    ) {
        this.statsSender = statsSender;
    }

    private void sendStats(String methodName, long measuredTimeMs) {
        System.out.println(Thread.currentThread().getId());
        statsSender.sendStats(methodName, measuredTimeMs);
    }

    private Object logExecutionImpl(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceedResult = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        Signature signature = joinPoint.getSignature();
        String packageName = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        sendStats(packageName + "#" + methodName, executionTime);
        return proceedResult;
    }

    @Around("@annotation(TrackTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        return logExecutionImpl(joinPoint);
    }

    @Around("@annotation(TrackAsyncTime)")
    public Object logExecutionAsyncTime(ProceedingJoinPoint joinPoint) throws Throwable {
        return CompletableFuture.runAsync(() -> {
            try {
                logExecutionImpl(joinPoint);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
    }
    
}
