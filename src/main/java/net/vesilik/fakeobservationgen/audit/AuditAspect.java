package net.vesilik.fakeobservationgen.audit;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class AuditAspect {
    @Around("@annotation(auditableMethod)")
    public Object logMethodEntryExit(ProceedingJoinPoint joinPoint, AuditableMethod auditableMethod) throws Throwable {
        log.info("Method \"" + joinPoint.getSignature().getName() + "\" is started. Action type: " + auditableMethod.action());
        Object proceed = joinPoint.proceed();
        log.info("Method \"" + joinPoint.getSignature().getName() + "\" is finished");
        return proceed;
    }
}
