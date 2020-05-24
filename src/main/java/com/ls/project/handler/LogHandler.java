package com.ls.project.handler;

import com.ls.project.annotation.LogAnnotation;
import com.ls.project.entity.Log;
import com.ls.project.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class LogHandler {

    @Autowired
    private LogService logService;

    @Around(value = "@annotation(com.ls.project.annotation.LogAnnotation)")
    public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
        Log log = new Log();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String module = null;
        LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
        module = logAnnotation.module();
        if (StringUtils.isEmpty(module)) {
            throw new RuntimeException("没有指定日志module");
        }
        log.setModule(module);
        try {
            Object object = joinPoint.proceed();
            log.setFlag(true);
            logService.save(log);
            return object;
        } catch (Exception e) {
            log.setFlag(false);
            log.setRemark(e.getMessage());
            logService.save(log);
            throw e;
        }
    }
}
