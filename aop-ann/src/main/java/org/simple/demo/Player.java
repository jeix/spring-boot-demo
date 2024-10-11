package org.simple.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class Player {

    @Pointcut("execution(* org.simple.demo.*WorkService.*(..))")
    private void cut() {}

    @Pointcut("@annotation(org.simple.demo.Play)")
    private void playable() {}

    @Before("cut() && playable()")
    public void before(JoinPoint joinPoint) {
        log.info("before"); // (2)

        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        Object that = joinPoint.getThis();

        log.info("- args={}", args);
            // - args=RequestDto[subject=고구마, message=고사리 고라니 고도리]
        log.info("- kind={}", kind);
            // - kind=method-execution
        log.info("- signature={}", signature);
            // - signature=ResponseDto org.simple.demo.VinylWorkService.doit(RequestDto)
        log.info("  - declaringType={}", signature.getDeclaringType().getName()); // class
            //   - declaringType=org.simple.demo.VinylWorkService
        log.info("  - declaringTypeName={}", signature.getDeclaringTypeName());
            //   - declaringTypeName=org.simple.demo.VinylWorkService
        log.info("  - name={}", signature.getName());
            //   - name=doit
        log.info("- target={}", target);
            // - target=org.simple.demo.VinylWorkService@6f83d3ad
        log.info("  - class={}", target.getClass().getSimpleName());
            //   - class=VinylWorkService
        signature.getDeclaringType().cast(target);
        log.info("- that={}", that);
            // - that=org.simple.demo.VinylWorkService@6f83d3ad
        log.info("  - class={}", that.getClass().getSimpleName());
            //   - class=VinylWorkService$$SpringCGLIB$$0
    }

    @After("cut() && playable()")
    public void after(JoinPoint joinPoint) {
        log.info("after"); // (4)
    }

    @AfterReturning(value = "cut() && playable()", returning = "returnObj")
    public void afterReturning(JoinPoint joinPoint, Object returnObj) {
        log.info("afterReturning"); // (3)
        log.info("- return={}", returnObj);
            // - return=ResponseDto[subject=고구마, message=고구마]
    }

    @AfterThrowing(value = "cut() && playable()", throwing = "ex")
    public void afterThrowning(JoinPoint joinPoint, Exception ex) {
        log.info("afterThrowning"); // (3)
        log.info("- throwing={}", ex.toString());
            // - throwing=java.lang.IllegalArgumentException
    }

    @Around("cut() && playable()")
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("around"); // (1)

        Object returnObj = null;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            returnObj = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        stopWatch.stop();
        long ttms = stopWatch.getTotalTimeMillis();
        log.info("- taken={}ms", ttms); // (5)
            // - taken=12ms

        return returnObj;
    }
}
